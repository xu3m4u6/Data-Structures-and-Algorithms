// Implement Stack by using ArrayList

public class MyStackA {
  Node top;
  Node bottom;
  int length = 0;
  }

  public String peek() {
    if(length == 0){
      return null;
    }
    return top.value;
  }

  public MyStackA push(String value){
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
  
  public MyStackA pop(){
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

    MyStackA obj = new MyStackA();
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

