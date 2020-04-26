// Implement Stack by using ArrayList

import java.util.ArrayList;

public class MyStackA {
  
  ArrayList<String> mystack = new ArrayList<>();

  public String peek() {
    if (mystack.size() == 0){
      return null;
    }
    return mystack.get(mystack.size()-1);
  }

  public MyStackA push(String value){
    mystack.add(value);
    return this;
  }
  
  public MyStackA pop(){
    mystack.remove(mystack.size()-1);
    return this;
  }

  public Boolean isEmpty(){
    if(mystack.size() == 0){
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

