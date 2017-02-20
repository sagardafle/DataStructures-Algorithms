/** http://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 * 
 * LOGIC: 
 * Maintain two pointers – reference pointer and main pointer. 
 * Initialize both reference and main pointers to head. 
 * First move reference pointer to n nodes from head. 
 * Now move both pointers one by one until reference pointer reaches end. 
 * Now main pointer will point to nth node from the end. Return main pointer.
 */ 
public class NthPointerFromEnd{
    
    
   static Node head; // head of the list
 
    /* Linked List node */
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
     /*Drier program to test above methods */
    public static void main(String [] args)
    {
        
        NthPointerFromEnd llist = new NthPointerFromEnd();
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
       // llist.printNthFromLastIterative(3);
        llist.printNthFromLastRecursive(head,3);
    }
 
     /**
      * LOGIC: 
      * Recurse through the Linked list
        When we reach to the end of the list, base case will return 0
        Now with each pass­ing back call through stack, add 1 and return.
        When count hits k, print the value.

      */ 
      
      int printNthFromLastRecursive(Node head, int n){
          if(head==null){
			return 0;
		}
		int i = 1+ printNthFromLastRecursive(head.next, n);
		if(i==n){
			System.out.println("Node no. "+n+" from last is "+head.data);
		}
		return i;
      }
    /* Function to get the nth node from end of list */
    void printNthFromLastIterative(int n){
        if(head == null) return; 
       Node ref_pointer = head;
       Node main_pointer = head;
       for(int i=0;i<n;i++){
           ref_pointer = ref_pointer.next;
       }
       while(ref_pointer!=null){
           ref_pointer = ref_pointer.next;
           main_pointer = main_pointer.next;
       }
            System.out.println("Node no. "+n+" from last is "+
                               main_pointer.data);
        }

 
 
   
}
