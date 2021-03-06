import java.util.*;
class MinStackLeetcode {
    int min = Integer.MAX_VALUE;
    static Stack<Integer> stack = new Stack<Integer>();
    
    public static void main(String[] args){
        MinStackLeetcode minStack = new MinStackLeetcode();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("S "+stack);
        System.out.println("Size "+minStack.size());
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println("Size "+minStack.size());
        System.out.println("After 1st pop, min is: "+minStack.getMin()); 
        minStack.top();      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }
    
    public void push(int x) {
        // Whenever you add a new value and if it is a new min, make sure you add the previous min as well.
        if(x <= min){          
            stack.push(min);
            min=x;
        }
            stack.push(x);
        
    }

    public void pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        if(stack.pop() == min) {
            System.out.println("S "+stack);
            min=stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
    public int size(){
        return stack.size();
    }
}