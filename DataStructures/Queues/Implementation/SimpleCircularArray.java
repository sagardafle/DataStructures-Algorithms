/**
 * LOGIC: We add elements circularly and use 2 variables to keep track of front & rear.
 * 1. Why we need circular array instead of normal array?
 *  - If we use a normal array, then after certain set of enqueue/dequeue operations, 
 *        the indices at front and rear becomes useless. 
 *  - To avoid this, we make use of a cirular array where we treat last and first elements as contiguous.
 *  - So, if we have any free slots at the beginning, the rear pointer can easily go to its next free slot.
 * 
 * 2. Complexity: enqueue(),dequeue(),peek() and all other operations are O(1).
 * 
 * 3. Limitations: We always need to specify the maximum size of the queue on a prior basis. 
 */ 
import java.util.*;
public class SimpleCircularArray{
    static int CAPACITY = 4;
    int size, front, rear;
    
    int queuearr[];
    public SimpleCircularArray(int size){
        queuearr = new int[size];
        size = front = rear = 0;
    }
    public static void main(String args[]){
        SimpleCircularArray obj = new SimpleCircularArray(CAPACITY);
        obj.enqueue(1);
        obj.enqueue(2);
        obj.enqueue(3);
        obj.enqueue(4);
        //obj.enqueue(5);
        
        int valueatpeek = obj.peek();
        System.out.println("valueatpeek "+valueatpeek);
        
        int removedvalue = obj.dequeue();
        System.out.println("removedvalue "+removedvalue);
        valueatpeek = obj.peek();
        System.out.println("valueatpeek "+valueatpeek);
        removedvalue = obj.dequeue();
        System.out.println("removedvalue "+removedvalue);
        
        obj.enqueue(5); // as the capacity == 4, the rear will go to front and add this value. 
                        // This is the advantage of using a Circular Queue.
        
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