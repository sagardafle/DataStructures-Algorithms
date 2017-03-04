/**
 * Interface for stack
 */
public interface Stack<Integer> { 
public void push(int data);
public int pop();
public boolean isStackEmpty();
public boolean isStackFull();
public int peek();
}