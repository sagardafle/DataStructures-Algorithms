/**
 * Source: http://codereview.stackexchange.com/questions/73301/implementing-a-stack-using-a-simple-array-dynamic-array-and-linked-list
/**
 * Implement stack using array.
 */
public class StackUsingSimpleArray < Integer > implements Stack < Integer > {
    private int sizeOfStack;
    private int[] stackArray;
    private static int top; //top of stack

    public StackUsingSimpleArray(int sizeOfStack) {
        top = -1;
        stackArray = new int[sizeOfStack];
        this.sizeOfStack = sizeOfStack;
    }

    /**
     * pushes item in the stack.
     * 
     * @param data
     */
    public void push(int data) {
        if (isStackFull()) {
            throw new RuntimeException("stack is full cannot push");
        }
        stackArray[++top] = data;
    }

    /**
     * gets item from stack
     */
    public int pop() {
        if (isStackEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return (int) stackArray[top--];
    }

    /** 
     * Checks if the stack is empty or not
     * 
     * @return boolean
     */
    public boolean isStackEmpty() {
        return (top == -1);
    }

    /**
     * Check if the stack is full .
     * 
     * @return boolean
     */
    public boolean isStackFull() {
        return (top == sizeOfStack - 1);
    }

    /**
     * Looks at the top element in the stack
     */
    public int peek() {
        return (int) stackArray[top];
    }

    public static void main(String[] args) {
        StackUsingSimpleArray stacksinglearray = new StackUsingSimpleArray(4);
        stacksinglearray.push(10);
        stacksinglearray.push(20);
        stacksinglearray.push(30);
        stacksinglearray.push(40);

        for (int i = 0; i < 4; i++) {
            System.out.println("Popped value " + stacksinglearray.pop());
        }

    }
}