import java.util.*;
class ReverseQueue{
      Queue<Integer> myqueue = new LinkedList<Integer>();
      public static void main(String[] args){
            ReverseQueue reverseobj = new ReverseQueue();
            reverseobj.myqueue.offer(1);
            reverseobj.myqueue.offer(2);
            reverseobj.myqueue.offer(3);
            reverseobj.myqueue.offer(4);
            reverseobj.myqueue.offer(5);
            reverseobj.myqueue.offer(6);
            
            System.out.println("Original Queue: "+reverseobj.myqueue);
            Queue<Integer> reversedqueue =  reverseobj.reverseQueue(reverseobj.myqueue);
            System.out.println("Reversed Queue: "+reversedqueue);
      }
      
      public Queue<Integer> reverseQueue(Queue<Integer> myqueue){
            Stack<Integer> s = new Stack<>();
            
            /*Remove items from queue and push to Stack*/
            while(!myqueue.isEmpty()){
                  s.push(myqueue.poll());
            }
            
            /*Push back the elements into Queue from Stack*/
            while(!s.isEmpty()){
                  myqueue.offer(s.pop());
            }
            
            return myqueue;
            
      }
      
}