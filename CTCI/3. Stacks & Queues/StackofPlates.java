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
    
    public Stack getLastStack(){
       if(platesstack.size()==0) return null;
       return platesstack.get(platesstack.size()-1) ;
    }
    
}