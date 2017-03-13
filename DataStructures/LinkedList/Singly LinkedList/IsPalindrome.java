/**
 * LOGIC : O(n) time and O(1) extra space.
 * 1. Divide the list into 2 halves.
 *    1.1 Traverse using slow-fast logic ( to find median)
 * 2. Set slow.next as the secondhead for the 2nd list. 
 * 3. Reverse second list. 
 * 4. Iterate the first half and the reversed second half to check if the data are same.
 *    If not, break loop and return false.
 * 
 * 
 **/
public class IsPalindrome {
    
     public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    Node head = null;
    Node current = null;
    Boolean isPalindrome = true;
    int nodeLength =0;
    public static void main(String args[]){
         IsPalindrome palindromeobj = new IsPalindrome();
       /**
        * Testcase 1 : Checking for ODD number of values in the list.
        * Insert values from the End.
        **/
        // palindromeobj.insertAtEnd(100);
        // palindromeobj.insertAtEnd(200);
        // palindromeobj.insertAtEnd(300);  
        // palindromeobj.insertAtEnd(200);
        // palindromeobj.insertAtEnd(100);
        // palindromeobj.printLinkedList();
        
        /**
        * Testcase 2 : Checking for EVEN number of values in the list.
        * Insert values from the End.
        **/
        
        palindromeobj.insertAtEnd(100);
        palindromeobj.insertAtEnd(200);
        palindromeobj.insertAtEnd(200);  
        palindromeobj.insertAtEnd(100);
        palindromeobj.printLinkedList();
        System.out.println("Is Palindrome "+palindromeobj.checkIfPalindrome());
    }
    
    public boolean checkIfPalindrome(){
        Node firsthead = head;
        Node p1 = head;
        Node p2 = head;
        Node prev = null;
        Node next = null;
        Node secondhead = null;
        if(nodeLength%2!=0){
        while(p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
         secondhead = p1;
        }else {
            while(p2.next.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
            secondhead = p2;
            p1.next= null;
        }
        
        current = secondhead;
        while(current.next!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        secondhead = current;
        current.next = prev;
        
        while(firsthead != null || secondhead != null){
            if(firsthead.data!=secondhead.data){
                isPalindrome = false;
            }
            firsthead = firsthead.next;
            secondhead = secondhead.next;
        }
        return isPalindrome;
    }
    
    public void insertAtEnd(int nodeData){
        Node newNodeToBeAdded = new Node(nodeData);
        if(nodeLength == 0){
            head = newNodeToBeAdded;
            current = head;
            current.next = null;
            nodeLength++;
        }else{
            current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNodeToBeAdded;
            newNodeToBeAdded.next = null;
            nodeLength++;
        }
    }
    
    public void printLinkedList(){
        System.out.println("=====Length of the List===== " +nodeLength);
        if(head!=null){
            current = head;
            System.out.println("=======Printing the List======");
        while(current!=null){
          System.out.print(current.data +" -> ");
          current = current.next;
         }
        }
    }
}