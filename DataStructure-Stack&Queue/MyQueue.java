public class MyQueue {
	private Node first;
	private Node last;
	private int length;

	public MyQueue(){
		first = null;
		last = null;
		length = 0;
	}

	public class Node {
		String value;
		Node next;

		Node(String data) {
			value = data;
			next = null;
		}
	}


	public String peek() {
		if (length == 0){
			return null;
		}
		return first.value;
	}

	public MyQueue enqueue(String value) {
		Node newNode = new Node(value);
		if(length == 0){
			first = newNode;
			last = newNode;
		}else{
			last.next = newNode;
			last = newNode;
		}

		length++;
		return this;
	}
	
	public MyQueue dequeue() {
		if(length == 0){
			return this;
		}
		if(length == 1){
			last = null;
		}
		// Node holdingPointer = first;
		first = first.next;
		length--;
		return this;
	}

	public Boolean isEmpty() {
		if(length == 0){
			return true;
		}
		return false;
	}


	public static void main(String[] args){
		
		MyQueue myqueue = new MyQueue();
		System.out.println("The queue is empty? " + myqueue.isEmpty());

		myqueue.enqueue("Joy");
		System.out.println(myqueue.peek());
		myqueue.enqueue("Matt");
		System.out.println(myqueue.peek());
		myqueue.enqueue("Pavel");
		System.out.println(myqueue.peek());
		System.out.println("The queue is empty? " + myqueue.isEmpty());

		myqueue.dequeue();
		System.out.println(myqueue.peek());
		myqueue.dequeue();
		System.out.println(myqueue.peek());
		myqueue.dequeue();
		System.out.println(myqueue.peek());
		System.out.println("The queue is empty? " + myqueue.isEmpty());

	}

}