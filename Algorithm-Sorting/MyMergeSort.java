class MyMergeSort {
	static int[] mergeSort(int[] array) {
		if (array.length === 1) {
		    return array;
		  }
		  // Split Array in into right and left

		  return merge(
		    mergeSort(left),
		    mergeSort(right)
		  )
	}
	
	static int[] merge(in[] left, int[] right){

	}


	public static void main(String[] args) {
		int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		int[] answer = mergeSort(numbers);
		for (int num: answer)
			System.out.print(num + " ");
	}
}