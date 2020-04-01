

class ReverseString{

	static String reverse(String input){

		char[] sToCharArray = input.toCharArray();
		int left = 0;
		int right = sToCharArray.length-1;


		for (left=0; left < right; left++, right--){
			char tmp = sToCharArray[left];
			sToCharArray[left] = sToCharArray[right];
			sToCharArray[right] = tmp;
		}

		String result = new String(sToCharArray);
		return result;
	}

	static String reverse2(String input){

		char[] sToCharArray = input.toCharArray();
		int elements = sToCharArray.length;

		char[] backward = new char[elements];


		for (int index = 0; index < elements; index++){
			backward[index] = sToCharArray[elements-index-1];
		}

		String result = new String(backward);
		return result;
	}


	public static void main (String[] args){
		
		String s = "Hello everyone!";

		System.out.println(reverse(s));
		System.out.println(reverse2(s));

	}
}