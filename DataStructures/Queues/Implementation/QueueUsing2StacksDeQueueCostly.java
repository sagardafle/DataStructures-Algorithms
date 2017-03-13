/*
LOGIC - I:  Making DeQUEUE operation COSTLY.
1. Keep the PUSH SIMPLE. Push the elements to S1.
2. Check if s2 is empty. If it is, pop all the elements from s1 and push it onto s2.
   Return the topmost element of s2 in either case.
*/
import java.util.*;
public class QueueUsing2StacksDeQueueCostly{
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();
       public static void main(String[] args){
             QueueUsing2StacksDeQueueCostly obj = new QueueUsing2StacksDeQueueCostly();
             for(int i=1;i<=6;i++){
                   obj.enqueue(i);
             }
             
             for(int i=1;i<=6;i++){
                   System.out.print(obj.dequeue()+" -> ");
             }
             
       }
       
       /*Simple PUSH*/
       public void enqueue(int data){
             s1.push(data);
       }
       
       /* POP */
       public int dequeue(){
             if(s2.isEmpty()){
                   while(!s1.isEmpty()){
                         s2.push(s1.pop());
                   }
             }
             return s2.pop();
       }
}