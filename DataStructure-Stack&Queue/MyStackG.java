// Accept multiple type of input

import java.util.EmptyStackException;

public class MyStackG<T> {
	
	private static class StackNode<T> {
		private T data;
		private StackNode<T> next;

		public StackNode (T data) {
			this.data = data;
		}
	}

	private StackNode<T> top;

	public T pop() {
		if (top == null){
			// throw new EmptyStackException();
			return null;
		}
		T item = top.data;
		top = top.next;
		return item;
	}

	public void push(T item) {
		StackNode<T> t = new StackNode<T>(item);
		t.next = top;
		top = t;
	}

	public T peek() {
		if (top == null){
			// throw new EmptyStackException();
			return null;
		}
		return top.data;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public static void main(String[] args) {
		MyStackG<String> obj = new MyStackG<>();
		System.out.println("The stack is empty? " + obj.isEmpty());

	    obj.push("google");
	    System.out.println(obj.peek());
	    obj.push("udemy");
	    System.out.println(obj.peek());
	    obj.push("discord");
	    System.out.println(obj.peek());

	    System.out.println("The stack is empty? " + obj.isEmpty());

	    obj.pop();
	    System.out.println(obj.peek());
	    obj.pop();
	    System.out.println(obj.peek());
	    obj.pop();
	    System.out.println(obj.peek());
	    System.out.println("The stack is empty? " + obj.isEmpty());


	    MyStackG<Integer> obj2 = new MyStackG<>();
		System.out.println("The stack is empty? " + obj2.isEmpty());

	    obj2.push(1);
	    System.out.println(obj2.peek());
	    obj2.push(2);
	    System.out.println(obj2.peek());
	    obj2.push(3);
	    System.out.println(obj2.peek());

	    System.out.println("The stack is empty? " + obj2.isEmpty());

	    obj2.pop();
	    System.out.println(obj2.peek());
	    obj2.pop();
	    System.out.println(obj2.peek());
	    obj2.pop();
	    System.out.println(obj2.peek());
	    System.out.println("The stack is empty? " + obj2.isEmpty());
		
	}

}