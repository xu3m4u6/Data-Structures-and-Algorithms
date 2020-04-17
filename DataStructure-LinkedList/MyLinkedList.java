

public class MyLinkedList {
	MyNode head;
	MyNode tail = head;
    int length = 0;

	public class MyNode {
		int value;
		MyNode next;

		MyNode(int data) { 
			value = data;
			next = null;
		} 
	}

	public MyLinkedList append(int data){

		MyNode newNode = new MyNode(data);
		System.out.println("\nAdding value: " + newNode.value);

		if (length==0) {
			head = newNode;
			tail = head;
			length++;
			this.printList();
		} else {
			tail.next = newNode;
			tail = newNode;
			length++;
			this.printList();
		}
		return this;
	}

	public MyLinkedList prepend(int data){

		MyNode newNode = new MyNode(data);
		System.out.println("\nAdding head: " + newNode.value);

		newNode.next = head;
		head = newNode;
		length++;
		this.printList();
		
		return this;
	}

	public MyLinkedList insert(int index, int data){

		// check params
		if(index >= length){
			return this.append(data);
		}
		if(index == 0){
			return this.prepend(data);
		}

		MyNode newNode = new MyNode(data);
		System.out.println("\nInserting " + data + " at index: " + index);
		
		MyNode leader = this.traverseToIndex(index-1);
		MyNode holdingPointer = leader.next;
		leader.next = newNode;
		newNode.next = holdingPointer;
		length++;
		this.printList();
		
		return this;
	}

	public MyLinkedList remove(int index){
		// check param
		if(index < 0 || index >= length){
			System.out.println("Index out of bound.");
			return this;
		}

		System.out.println("\nRemoving index: " + index);

		MyNode leader = this.traverseToIndex(index-1);
		MyNode unWanted = leader.next;
		leader.next = unWanted.next;
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
		MyLinkedList myList = new MyLinkedList();

		myList.append(10);
		myList.append(5);
		myList.append(16);
		myList.prepend(1);
		myList.insert(2, 99);
		myList.insert(20, 88);
		myList.insert(0, 666);
		myList.remove(2);
		myList.remove(300);
		System.out.println("Length of the Linked List: " + myList.length);
	}
}