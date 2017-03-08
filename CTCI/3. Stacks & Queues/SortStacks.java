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
class SortStacks{
    static Stack<Integer> original = new Stack<>();
    static Stack<Integer> sorted = new Stack<>();
    public static void main(String[] args){
        SortStacks sort = new SortStacks();
        original.push(1);
        original.push(2);
        original.push(3);
        original.push(4);
        original.push(5);
        System.out.println("Original Stack: "+original);
       // sort.sortUsingOneOnlyStack(original);
        Stack<Integer> sorted = sort.sortStackRecursively(original);
        System.out.println("Sorted Stack: "+sorted);
    }
    
    public void sortUsingOneOnlyStack(Stack original){
        while(!original.isEmpty()){
            int temp = (int) original.pop();
           while(!sorted.isEmpty() && sorted.peek() > temp){ 
               original.push(sorted.pop()); //Push the higher value back to original stack.
           }
           sorted.push(temp);
        }
    }
    
    
    public static Stack sortStackRecursively(Stack s){
          if(s.isEmpty()) return s;
          int data = (int) s.pop();
          sortStackRecursively(s);
          System.out.println("Calling insertAtBottom for element"+data);
          insertAtBottom(s,data);
          return s;
    }
    
    public static void insertAtBottom(Stack s, int data){ //same logic as reverse a stack except we compare the values here
        if(s.isEmpty() ||  data > (int) s.peek()){ 
            s.push(data);
            return;
        }
        int temp= (int) s.pop();
        insertAtBottom(s,data); 
        s.push(temp);
    }
}