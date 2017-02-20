import java.util.*;
public class IsPalindrome{
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args){
        IsPalindrome palindromelist = new IsPalindrome();
        /**
         * Test case - 1: Odd no of lists.
         */ 
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(30);
        head.next.next.next.next.next = new Node(20);
        head.next.next.next.next.next.next = new Node(10);
        
        /**
         * Test case - 2: Even no of lists.
         */ 
        // head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // head.next.next.next = new Node(30);
        // head.next.next.next.next = new Node(20);
        // head.next.next.next.next.next = new Node(10);
       
        boolean ispalindromelist = palindromelist.checkIfPalindromeIterative();
        System.out.print(ispalindromelist);
    }
    
    public boolean checkIfPalindromeIterative(){
        if(head == null) return false;
        Stack<Integer> s = new Stack();
        Node slowptr = head;
        Node fastptr = head;
        while(fastptr!=null && fastptr.next!=null){
            s.push(slowptr.data);
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            
        }
        System.out.println("Stack "+s);
        if(fastptr!= null) slowptr = slowptr.next; // This means that the list is odd. So no need to add the middle element in Stack, 
                                                    //as that be present exactly once.
        while(s.size()>0 || slowptr!=null) {
            if(s.pop() != slowptr.data) return false;
            slowptr = slowptr.next;
        }
        return true;
    }
}