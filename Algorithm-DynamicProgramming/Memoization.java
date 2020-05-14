import java.util.HashMap;

class Memoization {

	//initial function
	public static int addTo80(int n) {
		System.out.println("Long time");
		return n + 80;
	}

	// Memoization-1
	static HashMap<Integer, Integer> cache = new HashMap<>();
	public static int memoizeAddTo80(int n) {

		if (cache.containsKey(n)) {
			return cache.get(n);
		} else {
			System.out.println("Long time");
			int answer = n + 80;
			cache.put(n, answer);
			return answer;
		}
	}

	// Memoization-2: with no global scope.
	public interface Memoize {
	    int addTo80(int n);
	}
	public static Memoize makeMemoize () {
		final HashMap<Integer, Integer> cache2 = new HashMap<>();

		return new Memoize() {
			public int addTo80(int n) {
				if (cache2.containsKey(n)) {
					return cache2.get(n);
				} else {
					System.out.println("Long time");
					int answer = n + 80;
					cache2.put(n, answer);
					return answer;
				}
			}
		};
	}


	public static void main(String[] args) {
		
		// Initial
		System.out.println("Initial:");
		System.out.println(addTo80(5));
		System.out.println(addTo80(5));
		System.out.println("------------------------");

		// Memoization-1
		System.out.println("Memoization-1:");
		System.out.println("1: " + memoizeAddTo80(5));
		System.out.println("2: " + memoizeAddTo80(6));
		System.out.println("3: " + memoizeAddTo80(6));
		System.out.println("------------------------");

		// Memoization-2
		System.out.println("Memoization-2:");
		Memoize obj = makeMemoize();
		System.out.println("1: " + obj.addTo80(5));
		System.out.println("2: " + obj.addTo80(6));
		System.out.println("3: " + obj.addTo80(6));
	}
}
