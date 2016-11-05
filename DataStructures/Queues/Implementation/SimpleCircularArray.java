import java.util.*;
public class SimpleCircularArray{
    static int CAPACITY = 20;
    int size, front, rear;
    
    int queuearr[];
    public SimpleCircularArray(int size){
        queuearr = new int[size];
        size = front = rear = 0;
    }
    public static void main(String args[]){
        SimpleCircularArray obj = new SimpleCircularArray(CAPACITY);
        obj.enqueue(5);
        obj.enqueue(15);
        obj.enqueue(25);
        obj.enqueue(35);
        obj.enqueue(45);
        
        int valueatpeek = obj.peek();
        System.out.println("valueatpeek "+valueatpeek);
        
        int removedvalue = obj.dequeue();
        System.out.println("removedvalue "+removedvalue);
        System.out.println("valueatpeek "+valueatpeek);
        removedvalue = obj.dequeue();
        System.out.println("removedvalue "+removedvalue);
         System.out.println("=======Printing Queue=========");
         obj.display();
    }
    
    /**
     * 1. Enqueue -  inserts value at the rear position
     */ 
    public void enqueue(int data){
        if(size == CAPACITY){
            throw new IllegalStateException("Queue overflow!");
        } else {
            size++;  //increment the total size of the array
           queuearr[rear] = data;
           rear = (rear+1)%CAPACITY;  // set rear value
        }
    }
    
    /**
     * 2. DeQueue - deletes value from the front
     */
     
     public int dequeue(){
         int removeddata;
         if(size == 0){
             throw new IllegalStateException("Queue underflow!");
         } else {
             size--;
             removeddata = queuearr[front%CAPACITY];  
             queuearr[front] = Integer.MIN_VALUE;  //set to negative value
             front = (front+1)%CAPACITY; //front will be incremented.
         }
         return removeddata;
     }
     
     /**
      * 3. PEEK - seek the topmost value in queue
      */
      public int peek(){
          if(size == 0){
             throw new IllegalStateException("Queue underflow!");
         } else {
          return queuearr[front%CAPACITY];
         }
      }
      
      /**
       * 4. Iterator
       */ 
       public void display(){
            for(int i=0;i<queuearr.length;i++){
               System.out.print(queuearr[i]+ " ");
           }
       }
}