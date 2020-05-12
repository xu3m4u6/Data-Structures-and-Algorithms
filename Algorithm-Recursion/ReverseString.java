//Implement a function that reverses a string using iteration and then recursion!
import java.util.ArrayList;

class ReverseString {
	
	static String reverseStringRecursive(String str) {

		if(str.length() == 1){
			return str;
		}
		else{
			return reverseStringRecursive(str.substring(1))+str.charAt(0);
		}
	}

	static String reverseStringIterative(String str) {
		char[] arr = str.toCharArray();
		ArrayList<Character> reversed = new ArrayList<>();

		for (int i = arr.length - 1; i >= 0; i --){
			reversed.add(arr[i]);
		}

		String reversedString = "";
		for (Character c : reversed){
			reversedString += c;
		}
		return reversedString;
	}


	public static void main(String[] args) {

		System.out.println(reverseStringIterative("yoyo mastery"));
		System.out.println(reverseStringRecursive("yoyo mastery"));
		//should return: 'yretsam oyoy'
	}
}

