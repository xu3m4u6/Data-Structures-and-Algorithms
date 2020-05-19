class MyInsertionSort {
	static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++){
			int key = array[i];
			int prev = i -1;
			while(prev >= 0 && array[prev] > key){
				array[prev+1] = array[prev];
				prev--;
			}
			array[prev+1] = key;
		}
	}

	public static void main(String[] args) {
		int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		insertionSort(numbers);
		for (int num: numbers)
			System.out.print(num + " ");
	}
}