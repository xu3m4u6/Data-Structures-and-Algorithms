// Implement Queue by using stacks
import java.util.Stack;

class CrazyQueue {

    private Stack<Integer> first = new Stack<>();
    private Stack<Integer> last = new Stack<>();
    private Integer front; //first element in the queue
    
    public void enqueue(Integer value) {
        if(first.empty() && last.empty()){
            front = value;
        }

        while(!first.empty()){
            last.push(first.pop());
        }
        last.push(value);
    }

    public Integer dequeue() {
        while(!last.empty()){
            first.push(last.pop());
        }
        Integer popout = first.pop();
        if (!first.empty()){
            front = first.peek();
        }else{
            front = null;
        }
        return popout;
    }
    
    public Integer peek() {
        return front;
    }
    
    public boolean empty() {
        return first.empty() && last.empty();
    }

    public static void main(String[] args){
        CrazyQueue myqueue = new CrazyQueue();
        System.out.println("The queue is empty? " + myqueue.empty());

        myqueue.enqueue(1);
        System.out.println(myqueue.peek());
        myqueue.enqueue(2);
        System.out.println(myqueue.peek());
        myqueue.enqueue(3);
        System.out.println(myqueue.peek());
        System.out.println("The queue is empty? " + myqueue.empty());

        myqueue.dequeue();
        System.out.println(myqueue.peek());
        myqueue.dequeue();
        System.out.println(myqueue.peek());
        myqueue.dequeue();
        System.out.println(myqueue.peek());
        System.out.println("The queue is empty? " + myqueue.empty());
    }
}
