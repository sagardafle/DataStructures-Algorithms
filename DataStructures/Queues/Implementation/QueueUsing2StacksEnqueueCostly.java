/**
 * LOGIC:
 * This method makes sure that oldest entered element is always at the top of stack 1, 
 * so that deQueue operation just pops from stack1. 
 * To put the element at top of stack1, stack2 is used.
 */ 
 import java.util.*;
 public class QueueUsing2StacksEnqueueCostly{
       static Stack<Integer> s1 = new Stack<>();
       static Stack<Integer> s2 = new Stack<>();
       public static void main(String[] args){
             QueueUsing2StacksEnqueueCostly obj = new QueueUsing2StacksEnqueueCostly();
             for(int i=1;i<=6;i++){
                   obj.enqueue(i);
             }
             
             for(int i=1;i<=6;i++){
                   System.out.print(obj.dequeue()+" -> ");
             }
       }
       public void enqueue(int data){
             /* If s1 is not empty, push all elements onto s2*/
             while(!s1.isEmpty()){
                   s2.push(s1.pop());
             }
             /*Push data to Stack 1*/
             s1.push(data);
             /*Push Everything back to Stack 1*/
             while(!s2.isEmpty()){
                   s1.push(s2.pop()); //ensures that old element is always at the top.
             }
       }
       
       public int dequeue(){
             return s1.pop();
       }
 }