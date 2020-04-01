import java.util.ArrayList;
import java.util.Arrays;

class Array{

	public static void main(String[] args){
		String[] stringArray = {"aa", "bb", "cc", "dd"};
		// In Java, an array is a container object that holds a fixed number of values of a single type. The length of an array is established when the array is created. After creation, its length is fixed.

		// Resizable-array
		ArrayList<String> strings = new ArrayList<>(Arrays.asList("aa", "bb", "cc", "dd"));


		//add item at the end of the array
		strings.add("ee"); //O(1)
		System.out.println(strings);

		//remove the element at the specified position
		strings.remove(2); //O(1)
		System.out.println(strings);

		//Inserts the specified element at the specified position in this list.
		strings.add(0, "addFirst");  //O(n)
		strings.add(3, "addSecond");
		System.out.println(strings);

		ArrayList<String> test = new ArrayList<>();
		test.add(0, "add1");
		test.add(1, "add3");
		System.out.println(test);

	}
}
