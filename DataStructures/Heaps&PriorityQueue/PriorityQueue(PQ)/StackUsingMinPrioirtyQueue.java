import java.util.*;
import java.lang.System;
public class StackUsingMinPrioirtyQueue{
    static int a[] = {3,7,2,11,9,4};
    int size = 0;
    PriorityQueue<Integer> pq;
    static StackUsingMinPrioirtyQueue obj;
    public static void main(String args[]){
        
        obj = new StackUsingMinPrioirtyQueue(a.length);
        for(int i=0;i<a.length;i++){
            obj.push(a[i]);
        }
        
        
        System.out.println("Value popped: "+obj.pop());
        System.out.println("Value at Top: "+obj.top());
        System.out.println("PQ size: "+obj.size());
        System.out.println("PQ IsEmpty: "+obj.isEmpty());
        
    }
    public StackUsingMinPrioirtyQueue(int size){
        this.size = size;
        pq = new PriorityQueue<Integer>();
    }
    
    /**
     * 1. PUSH
     * **/
    public void push(int data){
         obj.insert(-System.currentTimeMillis(),data); 
    }
    
     public void insert(long time, int data) {
	  pq.offer(data);
	}
	
	
	/**
	 * 2. POP
	 */ 
	public int pop(){
	   return obj.extractMin();
	}
	
	public int extractMin() {
		return pq.poll();
	}
	
	/**
	 * 3.TOP
	 */
	 public int top(){
	     return pq.peek();
	 }
    
    /**
     * 4. SIZE
     */
     public int size(){
         return pq.size();
     }
     
     /**
      * 5.IsEmpty
      */ 
     public boolean isEmpty(){
         return pq.isEmpty(); 
     }
}