// Implement Stack by using Linked List

public class MyStackL {
  private Node top;
  private Node bottom;
  private int length;

  public MyStackL(){
    top = null;
    bottom = null;
    length = 0;
  }

  public class Node {
    String value;
    Node next;

    Node (String data){
      value = data;
      next = null;
    }
  }

  public String peek() {
    if(length == 0){
      return null;
    }
    return top.value;
  }

  public MyStackL push(String value){
    Node newNode = new Node(value);
    if (length == 0){
      bottom = newNode;
      top = newNode;
    }else{
      Node holdingPointer = top;
      top = newNode;
      top.next = holdingPointer;
    }
    length++;
    return this;
  }
  
  public MyStackL pop(){
    if(length == 0){
      return null;
    }
    if(top == bottom){
      top = null;
      bottom = null;
      length--;
      return this;
    }

    // Node holdingPointer = top;
    top = top.next;
    length--;
    return this;
  }

 
  public Boolean isEmpty(){
    if(length == 0){
      return true;
    }
    return false;
  }

  public static void main(String[] args){

    MyStackL obj = new MyStackL();
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
  }

}

