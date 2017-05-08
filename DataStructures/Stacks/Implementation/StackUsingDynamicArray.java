/**
 *
 * Source: http://codereview.stackexchange.com/questions/73301/implementing-a-stack-using-a-simple-array-dynamic-array-and-linked-list
 * Dynamic array implementation.
 * LOGIC: We make use of "Array Doubling technique". 
 * If the array is full, we create a new array of twice the size of original array. 
 * Then we copy all the values from old array to new array. 
 * If we start with n=1 and there are 32 items to be pushed onto array, 
    We do the doubling operation at "n=1", "n=2", "n=4", "n=5" (1,2,4,8,16,32) i.e log(n) times.
 * T(n) = O(n) 
 * Amortized time of a push operation is O(1).
 */
public class StackUsingDynamicArray<Integer> implements Stack<Integer>{

private int top ;
private int size;
private int[] array;

public StackUsingDynamicArray(int size) {
    top = -1;
    this.size = size;
    array = new int[size];
}

/**
 * pushes item in the stack.
 * 
 * @param data
 */
public void push(int data) {            
    if(isStackFull()) {
        int[] array2 = new int[size * 2];
        System.arraycopy(array, 0, array2, 0, array.length);
        array = array2;
    }
    array[++ top] = data;
}

/**
 * gets item from the stack.
 */
public int pop() {
    return (int) array[top -- ];
}

/**
 * check if stack is empty
 */
public boolean isStackEmpty() {
    return (top == -1);
}

/**
 * check if stack is full
 */
public boolean isStackFull() {
    return (top == size - 1 );
}

/**
 * check the element from top of stack.
 */
public int peek() {
    return (int) array[top];
}

public static void main(String[] args) {
        StackUsingDynamicArray stackdynamicarray = new StackUsingDynamicArray(4);
        stackdynamicarray.push(10);
        stackdynamicarray.push(20);
        stackdynamicarray.push(30);
        stackdynamicarray.push(40);
        stackdynamicarray.push(50);

        for (int i = 0; i < 4; i++) {
            System.out.println("Popped value " + stackdynamicarray.pop());
        }
    }
}