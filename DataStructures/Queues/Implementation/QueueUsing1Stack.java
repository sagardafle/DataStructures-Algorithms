/**
 * LOGIC: 
      1. enqueue() Operation:
            Push the element to the Stack.
      2. deQueue() Operation (Recursion): 
            2.1 Pop all the elements from Main Stack recursively until Stack item count is equal to 1.
            2.2 If Stack item count = 1, Pop item from Stack, Print it & Return.
            2.3 Push all popped element back to Stack as shown below.
 * * 
 */
import java.util.*;
class QueueUsing1Stack {
    Stack < Integer > mystack = new Stack < > ();
    public static void main(String[] args) {
        QueueUsing1Stack queuesinglestack = new QueueUsing1Stack();
        queuesinglestack.enqueue(100);
        queuesinglestack.enqueue(200);
        queuesinglestack.enqueue(300);
        queuesinglestack.enqueue(400);
        int size = queuesinglestack.mystack.size();
        for (int i = 0; i < size; i++) {
            queuesinglestack.dequeue();
        }
    }

    public void enqueue(int val) {
        mystack.push(val);
    }

    public void dequeue() {

        if (mystack.size() == 1) {
            System.out.println(mystack.pop());
            return;
        }
        int data = mystack.pop();
        dequeue();
        mystack.push(data);
    }

}