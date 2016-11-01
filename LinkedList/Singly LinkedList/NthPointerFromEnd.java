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
    Node head; // head of the list
 
    /* Linked List node */
    class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
 
    /* Function to get the nth node from end of list */
    void printNthFromLast(int n)
    {
       Node ref_pointer = head;
       Node main_pointer = head;
       int i=0;
       while(ref_pointer!=null && i<=n){
           ref_pointer = ref_pointer.next;
           i++;
       }
       while(ref_pointer!=null){
           ref_pointer = ref_pointer.next;
           main_pointer = main_pointer.next;
       }
            System.out.println("Node no. "+n+" from last is "+
                               main_pointer.data);
        }
    
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
 
    /*Drier program to test above methods */
    public static void main(String [] args)
    {
        NthPointerFromEnd llist = new NthPointerFromEnd();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);
        llist.push(45);
        llist.push(55);
 
        llist.printNthFromLast(3);
    }
}
