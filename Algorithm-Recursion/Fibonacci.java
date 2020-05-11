class Fibonacci {
// Given a number N return the index value of the Fibonacci sequence, where the sequence is:
// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ...
// the pattern of the sequence is that each value is the sum of the 2 previous values, that means that for N=5 → 2+3=5
//For example: fibonacciRecursive(6) should return 8

	static int fibonacciIterative(int n){
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < n + 1; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
	
	static int fibonacciRecursive(int n) {
		if(n < 2){
			return n;
		}
		return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
	}


	public static void main(String[] args) {

		System.out.println(fibonacciIterative(3));
		System.out.println(fibonacciRecursive(3));
	}
}