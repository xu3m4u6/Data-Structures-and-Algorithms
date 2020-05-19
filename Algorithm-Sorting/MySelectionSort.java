class MySelectionSort {
	static void selectionSort(int[] array) {
		for (int i = 0; i < array.length; i++){
			int minIndex = i;
			int temp = array[i];
			for (int j = i+1; j < array.length; j++){
				if (array[j] < array[minIndex])
					minIndex = j;
			}
			array[i] = array[minIndex];
			array[minIndex] = temp;
		}
	}
	public static void main(String[] args) {
		int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		selectionSort(numbers);
		for (int num: numbers)
			System.out.print(num + " ");
	}
}