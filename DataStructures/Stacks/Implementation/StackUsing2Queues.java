/** 
 * LOGIC:
 * PUSH : 
 * 1. Check if Q1 is empty , If yes, push the data to Q2.
 *    Else, push data to Q1.
 * POP: 
 * 1. If Q1 is empty, transfer (n-1) elements from Q2 to Q1. Pop the last value in Q2 and return.
 * 2. Else if Q2 is empty, transfer (n-1) elements from Q1 to Q2. Pop the last value in Q1 and return.
 */

import java.util.*;
class StackUsing2Queues {
    static Queue < Integer > q1, q2;
    public static void main(String[] args) {
        StackUsing2Queues s2q = new StackUsing2Queues();
        q1 = new LinkedList();
        q2 = new LinkedList();
        for (int i = 1; i <= 7; i++) {
            s2q.push(i);
        }

        for (int i = 1; i <= 7; i++) {
            System.out.print(s2q.pop() + " -> ");
        }
    }

    /* PUSH */
    public void push(int data) {
        if (q1.isEmpty()) {
            q2.offer(data);
        } else {
            q1.offer(data);
        }
    }

    /* POP */
    public int pop() {
        int i = 0, size;
        if (q1.isEmpty()) {
            size = q2.size();
            //Transfer (n-1) elements from q2 to q1
            while (i < size - 1) {
                q1.offer(q2.poll());
                i++;
            }
            return q2.poll();
        } else {
            size = q1.size();
            //Transfer (n-1) elements from q1 to q2
            while (i < size - 1) {
                q2.offer(q1.poll());
                i++;
            }
            return q1.poll();
        }
    }
}