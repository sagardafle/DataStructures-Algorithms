/**
 * LOGIC : 
 * 1. Create another stack , we name it 'sorted stack'. 
 * 2. WHile original stack is not null:
 *          1.1 Pop value from original stack.
 *          1.2 While, this value is less than peek of sorted stack:
 *              2.1 Keep on popping the value from sorted stack and add it to original stack.
 *          1.3 Push the value in 1.1 to sorted stack
 * O(N2) - time and space - O(N).
 * If we were asked to implement this using more than 1 stacks, we could have done it via QuickSort or mergesort. 
 */
 
import java.util.*;
class ReverseStack{
    static Stack<Integer> original = new Stack<>();
    static Stack<Integer> sorted = new Stack<>();
    public static void main(String[] args){
        ReverseStack sort = new ReverseStack();
        original.push(19);
        original.push(12);
        original.push(36);
        original.push(44);
        original.push(15);
        System.out.println("Original Stack: "+original);
       // sort.reverseUsingTwoStacks(original);
        Stack<Integer> sorted = sort.reverseStackRecursively(original);
        System.out.println("Sorted Stack: "+sorted);
    }
    
    public void reverseUsingTwoStacks(Stack original){
        while(!original.isEmpty()){
            int temp = (int) original.pop();
           while(!sorted.isEmpty()){ 
               original.push(sorted.pop()); //Push the higher value back to original stack.
           }
           sorted.push(temp);
        }
    }
    
    
    public static Stack reverseStackRecursively(Stack s){
          if(s.isEmpty()) return s;
          int data = (int) s.pop();
          reverseStackRecursively(s);
          System.out.println("Calling insertAtBottom for element "+data);
          insertAtBottom(s,data);
          return s;
    }
    
    public static void insertAtBottom(Stack s, int data){ //same logic as reverse a stack except we compare the values here
        if(s.isEmpty()){ 
            s.push(data);
            return;
        }
        int temp= (int) s.pop();
        insertAtBottom(s,data); 
        s.push(temp);
    }
}