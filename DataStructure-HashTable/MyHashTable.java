import java.util.LinkedList;
import java.util.ArrayList;

public class MyHashTable{

	// Create a class called HashNode to implement the linked list structure inside HashTable
	public class HashNode { 
	    String key; 
	    int value; 
	    HashNode next;
	     
	    public HashNode(String key, int value){ 
	        this.key = key; 
	        this.value = value;
	        this.next = null;
	    }
	}

	// Create a hash table with initialSize buckets
	private HashNode[] myHT;
	final private int initialSize = 50;

	public MyHashTable(){

		myHT = new HashNode[initialSize];
	}

	// hash function
	private int hash(String key) {
	    int hash = 0;
	    for (int i =0; i < key.length(); i++){
	        hash = (hash + Character.codePointAt(key, i) * i) % initialSize;
	    }
	    return hash;
	}

	// Adding key, value pair
	public MyHashTable set(String key, int value){
		ArrayList checkDuplicate = this.keys();

		if(checkDuplicate.contains(key)){
			return this;
		}
		else{
			int address = hash(key);
			if(myHT[address] == null){
				myHT[address] = new HashNode(key, value);
			}
			else{
				HashNode temp = myHT[address];
	            while(temp.next != null) {
	                temp = temp.next;
	            }
	            temp.next = new HashNode(key, value);
			}
		}
		return this;
	}

	// Getting the value of the specific key
	public Integer get(String key) {
		int address = hash(key);
		HashNode temp = myHT[address];
		while(temp != null){
			if(temp.key == key){
				return temp.value;
			}
			temp = temp.next;
		}
		return null;
	}

	// return a list of all the keys contained in the Hash Table
	public ArrayList keys() {
		ArrayList<String> keylist = new ArrayList<>();

		for (int i=0; i<initialSize; i++){
			HashNode temp = myHT[i];
			while(temp != null){
				keylist.add(temp.key);
				temp = temp.next;
			}
		}

		return keylist;
	}


	public static void main(String[] args){

		MyHashTable myHashTable = new MyHashTable();
		
		myHashTable.set("grapes", 10000);
		System.out.println(myHashTable.get("grapes"));
		
		myHashTable.set("apples", 9);
		System.out.println(myHashTable.get("apples"));

		myHashTable.set("apples", 9); //duplicate key will not be added
		
		System.out.println(myHashTable.get("bananas"));

		myHashTable.set("pears", 33);
		System.out.println(myHashTable.get("pears"));

		ArrayList keys = myHashTable.keys();
		System.out.println("The Hash Table contains:");
		for (int i=0; i<keys.size(); i++){
			System.out.println(keys.get(i));
		}

	}
}