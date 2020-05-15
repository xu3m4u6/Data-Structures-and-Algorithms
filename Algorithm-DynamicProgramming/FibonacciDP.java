import java.util.HashMap;

class FibonacciDP {
	
	//Time: O(2^n) Space: O(1)
	static int calculations = 0;
	public static int fibonacci(int n) {
		calculations++;
		if(n < 2){
			return n;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	//Time: O(n) Space: O(n)
	public interface FibonacciMaster {
		int fib(int n);
	}
	static int calculations2 = 0;
	public static FibonacciMaster makefib () {
		final HashMap<Integer, Integer> cache2 = new HashMap<>();

		return new FibonacciMaster() {
			public int fib(int n) {
				calculations2++;
				if (cache2.containsKey(n)) {
					return cache2.get(n);
				} else {
					if (n < 2) {
						return n;
					} else {
						cache2.put(n, fib(n-1) + fib(n-2));
						return cache2.get(n);
					}
				}
			}
		};
	}

	// Bottom Up Time: O(n) Space: O(n)
	public static int fibonacciMaster2(int n){
		int[] arr = new int[n+1];
		arr[0] = 0;
		arr[1] = 1;
		for (int i = 2; i < n + 1; i++){
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}

	
	public static void main(String[] args) {
		
		System.out.println("Recursion:");
		System.out.println("Fibonacci(35)= " + fibonacci(35));
		System.out.println("we did " + calculations + " calculations with recursion");
		System.out.println("----------------------------------");

		FibonacciMaster obj = makefib();
		System.out.println("DP:");
		System.out.println("Fibonacci(35)= " + obj.fib(35)); 
		System.out.println("we did " + calculations2 + " calculations with DP");
		System.out.println("----------------------------------");

		System.out.println("Bottom Up:");
		System.out.println("Fibonacci(35)= " + fibonacciMaster2(35)); 


	}
}