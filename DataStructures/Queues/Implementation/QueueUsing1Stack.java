/**
 * LOGIC: 
 * 1. ENQUEUE: Push the value normally in stack. 
 * 2. DEQUEUE: 
 *              2.1 Pop the value from the stack.
 *              2.2 If the stack is empty, return value from 2.1
 *                     Else   If stack is not empty, 
 *                            Remove the bottom most value in the stack (This is to be returned as dequeue output).
 *                  
 *              2.3 Push back the value onto the same stack that was popped in 2.1
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
            System.out.println(" Value removed " + queuesinglestack.dequeue());
        }
    }

    public void enqueue(int val) {
        mystack.push(val);
    }

    public int dequeue() {

        int top = mystack.pop();
        if (mystack.isEmpty()) {
            return top;
        } else {
            int result = mystack.remove(0);
            mystack.push(top);
            return result;
        }
    }
}