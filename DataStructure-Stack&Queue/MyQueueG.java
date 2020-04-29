// Implement Generic Queue Class

import java.util.NoSuchElementException;

public class MyQueueG<T> {

	private static class QueueNode<T> {
		private T data;
		private QueueNode<T> next;

		public QueueNode(T value) {
			this.data = value;
		}
	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T item) {
		QueueNode<T> t = new QueueNode<T>(item);
		if (last != null) {
			last.next = t;
		}
		last = t;
		if (first == null) {
			first = last;
		}
	}

	public T remove() {
		if (first == null){
			// throw new NoSuchElementException();
			return null;
		}
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}

	public T peek() {
		if (first == null){
			// throw new NoSuchElementException();
			return null;
		}
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}


	public static void main(String[] args) {
		MyQueueG<String> myqueue = new MyQueueG<>();
		System.out.println("The queue is empty? " + myqueue.isEmpty());

		myqueue.add("Joy");
		System.out.println(myqueue.peek());
		myqueue.add("Matt");
		System.out.println(myqueue.peek());
		myqueue.add("Pavel");
		System.out.println(myqueue.peek());
		System.out.println("The queue is empty? " + myqueue.isEmpty());

		myqueue.remove();
		System.out.println(myqueue.peek());
		myqueue.remove();
		System.out.println(myqueue.peek());
		myqueue.remove();
		System.out.println(myqueue.peek());
		System.out.println("The queue is empty? " + myqueue.isEmpty());
	}
}