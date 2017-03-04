/**
 * Logic:
 *  1. Keep 2 stacks, let's call them input and output.
    2. Enqueue: Push the new element onto inbox
    3. Dequeue: If output is empty, refill it by popping each element from inbox and pushing it onto output
                Pop and return the top element from output
                Using this method, each element will be in each stack exactly once - 
                meaning each element will be pushed twice and popped twice, giving amortized constant time operations.
 */ 
import java.util.*;
public class QueueUsing2Stacks{
    private Stack<Integer> input = new Stack<>();
    private Stack<Integer> output = new Stack<>();
    public static void main(String[] args){
        QueueUsing2Stacks queue2stacks = new QueueUsing2Stacks();
        queue2stacks.enqueue(100);
        queue2stacks.enqueue(200);
        queue2stacks.enqueue(300);
        queue2stacks.enqueue(400);
        
        System.out.println("Stacks size "+queue2stacks.input.size());
        for(int i=0;i<4;i++){
            int val = queue2stacks.dequeue();
            System.out.println("Popped val = "+val);
        }
    }
    
    public void enqueue(int val){
        input.push(val);
    }
    
    public int dequeue(){
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }
        return (int) output.pop();
    }
}