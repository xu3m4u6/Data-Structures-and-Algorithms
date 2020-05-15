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
	

	public static void main(String[] args) {
		System.out.println("Recursion: " + fibonacci(35)); 
		System.out.println("we did " + calculations + " calculations with recursion");
		System.out.println("-----------------------------");

		FibonacciMaster obj = makefib();
		System.out.println("DP: " + obj.fib(35));
		System.out.println("we did " + calculations2 + " calculations with DP");
		System.out.println("-----------------------------");
	}
}