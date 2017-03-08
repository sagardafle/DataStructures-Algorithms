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
    static Node left;
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
        
        left = head; //setting node
        /**
         * Test case - 2: Even no of lists.
         */ 
        // head = new Node(10);
        // head.next = new Node(20);
        // head.next.next = new Node(30);
        // head.next.next.next = new Node(30);
        // head.next.next.next.next = new Node(20);
        // head.next.next.next.next.next = new Node(10);
       
        // boolean ispalindromelist = palindromelist.checkIfPalindromeIterative();
        // System.out.print(ispalindromelist);
         boolean ispalindromelist = palindromelist.checkIfPalindromeRecursive(head);
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
    
/**
 * LOGIC : 
 * 1. Call the function with left, which is head. 
 * 2. If left is null, return true. 
 * 3. Else recursively call the function passing head.next(left.next) till we reach the end of the list.
 * 4. Once we reach end, we compare the right node with left. 
 *    4.1 If both are equal , we move left to left.next.
 *    4.2 Return true. 
 */
public boolean checkIfPalindromeRecursive(Node right){
     
		if(right==null){
			return true;
		}
		boolean result = checkIfPalindromeRecursive(right.next);
		if(result==true && right.data==left.data){
			left = left.next;
			return true;
		}
		return false;
    }
}