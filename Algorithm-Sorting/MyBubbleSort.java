class MyBubbleSort {
	static void bubbleSort(int[] array) {
		for (int i = array.length - 1; i > 0; i--){
			for (int j = 0; j < i; j++){
				if (array[j] > array[j+1]){
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};
		bubbleSort(numbers);
		for (int num: numbers)
			System.out.print(num + " ");
	}
}