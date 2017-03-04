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
        original.push(13);
        original.push(33);
        original.push(2);
        original.push(6);
        System.out.println("Original Stack: "+original);
        sort.sortUsingOneOnlyStack(original);
        System.out.println("Sorted Stack: "+sorted);
    }
    
    public void sortUsingOneOnlyStack(Stack original){
        while(!original.isEmpty()){
            int temp = (int) original.pop();
           while(!sorted.isEmpty() && sorted.peek() > temp){
               original.push(sorted.pop());
           }
           sorted.push(temp);
        }
    }
}