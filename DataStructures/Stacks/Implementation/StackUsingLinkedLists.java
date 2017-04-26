/**
 * Source: http://codereview.stackexchange.com/questions/73301/implementing-a-stack-using-a-simple-array-dynamic-array-and-linked-list
 */ 
import java.util.*;
class Node < Integer > {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
    
    public String toString(){
        return "Data: "+getData();
    }

}
public class StackUsingLinkedLists < Integer > implements Stack < Integer > {
    private int sizeOfStack;
    Node < Integer > top;

    public StackUsingLinkedLists(int sizeOfStack) {
        top = null;
        this.sizeOfStack = sizeOfStack;
    }

    /**
     * pushes item in the stack.
     * 
     * @param data
     */
     // values will be added in 40->30->20->10 format. 
     //Values will be added to the front of the list.
    public void push(int data) {
        Node < Integer > newNode = new Node(data);
        newNode.setNext(top); //add previous top to next.
        top = newNode; // make the new node as head(top).
    }

    /**
     * gets item from the stack.
     */
    public int pop() {
        if (top != null) {
            int item = (int) top.getData();
            top = top.getNext();
            return item;
        }
        return -1;
    }

    public boolean isStackEmpty() {
        return (top == null);
    }

    public boolean isStackFull() {
        return false;
    }

    public int peek() {
        return (int) top.getData();
    }

    public static void main(String[] args) {
        StackUsingLinkedLists stacklinkedlists = new StackUsingLinkedLists(4);
        stacklinkedlists.push(10);
        stacklinkedlists.push(20);
        stacklinkedlists.push(30);
        stacklinkedlists.push(40);
        System.out.println("Top after all push "+stacklinkedlists.top.getData());
        for (int i = 0; i < 4; i++) {
            System.out.println("Popped value -> "+stacklinkedlists.pop());
        }
    }

}