

public class DoublyLinkedList {
	MyNode head;
	MyNode tail = head;
    int length = 0;

	public class MyNode {
		int value;
		MyNode next;
		MyNode prev;

		MyNode(int data) { 
			value = data;
			next = null;
			prev = null;
		} 
	}

	public DoublyLinkedList append(int data){

		MyNode newNode = new MyNode(data);
		System.out.println("\nAdding value: " + newNode.value);

		if (length==0) {
			head = newNode;
			tail = head;
			length++;
			this.printList();
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
			length++;
			this.printList();
		}
		return this;
	}

	public DoublyLinkedList prepend(int data){

		MyNode newNode = new MyNode(data);
		System.out.println("\nAdding head: " + newNode.value);

		head.prev = newNode;
		newNode.next = head;
		head = newNode;
		length++;
		this.printList();
		
		return this;
	}

	public DoublyLinkedList insert(int index, int data){

		// check params
		if(index >= length){
			System.out.println("\nInserting " + data + " at index: " + index);
			System.out.println("Index: " + index + " out of bound. Appending to the tail.");
			return this.append(data);
		}
		if(index == 0){
			System.out.println("\nInserting " + data + " at index: " + index);
			return this.prepend(data);
		}

		MyNode newNode = new MyNode(data);
		System.out.println("\nInserting " + data + " at index: " + index);
		
		MyNode leader = this.traverseToIndex(index-1);
		MyNode follower = leader.next;
		leader.next = newNode;
		newNode.next = follower;
		newNode.prev = leader;
		follower.prev = newNode;
		length++;
		this.printList();
		
		return this;
	}

	public DoublyLinkedList remove(int index){
		// check param
		if(index < 0 || index >= length){
			System.out.println("\nCannot remove node at index: " + index + ", Index out of bound.");
			return this;
		}

		if(index == length-1){
			System.out.println("\nRemoving node at index: " + index + ", tail removed.");
			MyNode leader = this.traverseToIndex(index-1);
			leader.next = null;
			tail = leader;
			length--;
			this.printList();

			return this;
		}

		System.out.println("\nRemoving node at index: " + index);

		MyNode leader = this.traverseToIndex(index-1);
		MyNode unWanted = leader.next;
		MyNode follower = unWanted.next;
		leader.next = follower;
		follower.prev = leader;
		length--;
		this.printList();

		return this;
	}

	public MyNode traverseToIndex(int index){
		if(index == 0){
			return this.head;
		}
		MyNode currentNode = this.head;
		int counter = 0;
		while(counter < index){
			currentNode = currentNode.next;
			counter++;
		}
		return currentNode;
	}

	public void printList(){
		MyNode currentNode = this.head;
		System.out.print("LinkedList: ");

		while (currentNode != null){
			System.out.print(currentNode.value + " "); 
			currentNode = currentNode.next;
		}
		System.out.println();
	}


	public static void main(String[] args){
		DoublyLinkedList myList = new DoublyLinkedList();
		System.out.println("Length of the Linked List: " + myList.length);
		myList.append(10);
		myList.append(5);
		myList.append(16);
		myList.prepend(1);
		myList.insert(2, 99);
		myList.insert(20, 88);
		myList.insert(0, 666);
		myList.remove(2);
		myList.remove(300);
		myList.remove(5);
		System.out.println("Length of the List: " + myList.length);
		System.out.println("Tail of the List: " + myList.tail.value);
	}
}