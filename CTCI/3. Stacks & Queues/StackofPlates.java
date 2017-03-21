/* Imagine a (literal) stack of plates. 
If the stack gets too high, it might topple. 
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold. 
Implement a data structure SetOfStacks that mimics this. 
SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity. 
SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack 
(that is, pop() should return the same values as it would if there were just a single stack).
*/

import java.util.*;
class StackofPlates{
    static ArrayList<Stack> platesstack = new ArrayList<>();
     int capacity; //capacity of each stack
     
     StackofPlates(int capacity){
         this.capacity = capacity;
     }
    public static void main(String[] args){
        StackofPlates sop = new StackofPlates(3); //capacity = 3
        for(int i=1;i<=15;i++){
            sop.push(i);
        }
        System.out.println("No. of stacks: "+platesstack.size());
        System.out.println("Stack of Plates: "+platesstack);
        System.out.println("=================================================");
        System.out.println("Pop at 2nd stack: Removed value: "+sop.popAt(1));
        System.out.println("Stack of Plates after above pop: "+platesstack);
    }
    
    
    public void push(int val){
        Stack laststack = getLastStack(); 
        if(laststack!=null && laststack.size() < capacity) {
            //last stack has some capacity
            laststack.push(val);
        } else {
            //last stack is null or eith full. Time to create a new stack.
            Stack<Integer> newStack = new Stack<>();
            newStack.push(val);
            platesstack.add(newStack);
        }
    }
    
    //Pop should always operate on the last stack. If there is no last stack it shall raise an exception.
    public int pop(){
         Stack laststack = getLastStack();
         if(laststack == null) throw new EmptyStackException();
         int val = (int) laststack.pop();
         if(laststack.size() ==0) platesstack.remove(platesstack.size()-1); //remove the last stack from the arraylist.
         return val;
    }
    
    /**
     * Returns the last stack in the list.
     */ 
    public Stack getLastStack(){
       if(platesstack.size()==0) return null;
       return platesstack.get(platesstack.size()-1) ;
    }
    
    /**
     * Pop the topmost element of a specific stack in the plates-stack.
     */ 
    public int popAt(int index){
        if(index > platesstack.size()-1) {
            System.out.println("Invalid stack index");
            return -1;
        }
        Stack s = platesstack.get(index);
        int val = (int) s.pop();
        balance(index,index+1); //Balance the stack such as all the stacks except the last one are at their full capacity.
        return val;
    }
    
    /**
     * We will try to balance the left stack and right stack such that the void space in the left stack is filled back by the right stack.
     */ 
    public void balance(int left, int right){
        if(left > platesstack.size()-1 || right > platesstack.size()-1) return;
        int valuefromright = (int) platesstack.get(right).remove(0); //remove the bottom value from the right stack.
        platesstack.get(left).push(valuefromright); //push the above value back to left stack.
        // check if more balancing can be done to fill the void in left stack.
        balance(right, right+1); 
    }
}