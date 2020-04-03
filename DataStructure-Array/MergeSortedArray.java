

class MergeSortedArray {

	public static int[] mergeSortedArrays(int[] arr1, int[] arr2){

		int n1 = arr1.length;
		int n2 = arr2.length;

		if (n1 == 0){
			return arr2;
		}
		if (n2 == 0){
			return arr1;
		}

		int[] mergedArray = new int[n1+n2];
		int i = 0, j = 0, k = 0;

		while (i<n1 && j <n2) { 
            if (arr1[i] < arr2[j]) {
            	mergedArray[k++] = arr1[i++];
			}
            else{
            	mergedArray[k++] = arr2[j++]; 
            }
        } 

        while (i<n1){
        	mergedArray[k++] = arr1[i++];
        }

        while (j<n2){
        	mergedArray[k++] = arr2[j++];
        }

		return mergedArray;

	}

	public static void main(String[] args){
		
		int[] array1 = {0,3,4,31};
		int[] array2 = {3,4,6,30,55,67};
		
		int[] result = mergeSortedArrays(array1, array2);
		
		for (int i: result){
			System.out.println(i);
		}

	}
}
