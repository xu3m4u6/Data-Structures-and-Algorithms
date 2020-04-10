//Google Question
//Given an array = [2,5,1,2,3,5,1,2,4]:
//It should return 2

//Given an array = [2,1,1,2,3,5,1,2,4]:
//It should return 1

//Given an array = [2,3,4,5]:
//It should return undefined

import java.util.HashSet; 

class firstRecurringCharacter {

	static int firstRecurringCharacter(int[] input){

		HashSet<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < input.length; i++){
			if (set.contains(input[i])){
				return input[i];
			}
			set.add(input[i]);
		}

		return -999;

	}

	public static void main(String[] args){
		
		int[] input = {2,5,5,1,2,3,5,1,2,4};

		int result = firstRecurringCharacter(input);
		
		if (result == -999){
			System.out.println("First recurring character not found.");
		}else{
			System.out.println(result);
		}


	}

} 


//Bonus... What if we had this:
// [2,5,5,2,3,5,1,2,4]
// return 5 because the pairs are before 2,2

