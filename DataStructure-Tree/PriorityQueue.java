public class PriorityQueue<T> {

	private static class Node<T> {
		private T data;
		private int priority;
		private Node<T> next;

		public Node(T value, int rank) {
			data = value;
			priority = rank;
			next = null;
		} 
	}

	private Node<T> head;
	private int length;

	public PriorityQueue(){
		this.head = null;
		this.length = 0;
	}

	public void enqueue(T item, int priority){
		Node<T> newNode = new Node<>(item, priority);
		if(this.length == 0){
			head = newNode;
		}else{
			if(head.priority < newNode.priority){
				newNode.next = head;
				head = newNode;
			}else{
				Node<T> current = head.next;
				Node<T> prev = head;
				while(current != null){
					if(current.priority >= newNode.priority){
						prev = current;
						current = current.next;
					}else{
						break;
					}
				}
				prev.next = newNode;
				newNode.next = current;
			}
		}
		length++;
	}

    public T dequeue(){
    	if(length == 0)
    		return null;
    	Node<T> current = head;
    	head = head.next;
    	System.out.println(current.data + " has been removed.");
    	return current.data;
    }

    public T front(){
    	if(length == 0){
    		System.out.println("The Priority Queue is empty.");
    		return null;
    	}
    	return head.data;
    } 
    
    public boolean isEmpty(){
    	return length == 0 ? true : false;
    } 

    public void print(){
    	if(length == 0){
    		System.out.println("The Priority Queue is empty.");
    	}else{
    		System.out.println("The Priority Queue contains: ");
    		Node current = head;
	    	while(current != null){
	    		System.out.println("Data: " + current.data + ", Priority: " +current.priority);
	    		current = current.next;
	    	}
	    	System.out.println("END");
    	}
    }


    public static void main(String[] args){
    	PriorityQueue<String> myPQ = new PriorityQueue<>();

    	System.out.println("The Priority Queue is empty? " + myPQ.isEmpty());
    	myPQ.enqueue("Amy", 11);
    	System.out.println(myPQ.front());
    	myPQ.enqueue("Benson", 56);
    	System.out.println(myPQ.front());
    	myPQ.enqueue("Judy", 99);
    	System.out.println(myPQ.front());
    	myPQ.enqueue("Sophia", 63);
    	myPQ.enqueue("Andy", 11); // Same priority
    	myPQ.enqueue("Hank", 1);
    	System.out.println("The Priority Queue is empty? " + myPQ.isEmpty());
    	myPQ.print();

    	myPQ.dequeue();
    	System.out.println(myPQ.front());
    	myPQ.print();
    	myPQ.dequeue();
    	myPQ.dequeue();
    	myPQ.print();
    }
}

