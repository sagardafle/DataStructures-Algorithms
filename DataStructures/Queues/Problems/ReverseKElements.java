//Karumanchi
import java.util.*;
class ReverseKElements{
      Queue<Integer> myqueue = new LinkedList<Integer>();
      public static void main(String[] args){
            ReverseKElements reverseobj = new ReverseKElements();
            reverseobj.myqueue.offer(1);
            reverseobj.myqueue.offer(2);
            reverseobj.myqueue.offer(3);
            reverseobj.myqueue.offer(4);
            reverseobj.myqueue.offer(5);
            reverseobj.myqueue.offer(6);
            
            System.out.println("Original Queue: "+reverseobj.myqueue);
            Queue<Integer> reversedqueue =  reverseobj.reversedKQueue(reverseobj.myqueue,3);
            System.out.println("Reversed K elements Queue: "+reversedqueue);
      }
      
      public Queue<Integer> reversedKQueue(Queue<Integer> q, int k){
            Stack<Integer> s = new Stack<>();
            //Remove the first k elements from the Queue.
            for(int i=0;i<k;i++){
                  s.push(q.poll());
            }
            //Add the values from stack to queue --> Thereby reversing it.
            while(s.size()>0){
                  q.add(s.pop());
            }
            
            /*Wrap aroound rest of the elements*/
            for(int i=0;i<q.size()-k;i++){
                  q.add(q.remove());
            }
            return q;
      }
      
}