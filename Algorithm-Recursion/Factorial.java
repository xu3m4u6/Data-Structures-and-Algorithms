class Factorial {



// Write two functions that finds the factorial of any number. 
// One should use recursive, the other should just use a for loop
	static int findFactorialRecursive(int number) {
		if(number == 1){
			return 1;
		}
		return number * findFactorialRecursive(number-1);
	}

 	static int findFactorialIterative(int number) {
 		int answer = 1;
 		for(int i = 2; i <= number; i++){
 			answer = answer * i; 
 		}
 		return answer;
 	}


 	public static void main(String[] args) {

 		System.out.println(findFactorialRecursive(5));
 		System.out.println(findFactorialIterative(5));

 	}

}