/*2.4 Partition: Write code to partition a linked list around a value x, 
                 such that all currents less than x come before all currents greater than or equal to x. 
                 If x is contained within the list, the values of x only need to be after the elements less than x.
*/

public class PartitionList {
      static Node head;  // head of list
      int currentLength=0;
 
    /* Linked list Node*/
    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }
     
    
    public Node partitionAroundWith4pointers(int k){
          Node root = new Node(0);
          Node pivot = new Node(k);
          Node rootnext  = root, pivotnext = pivot;
          Node current = head;
          
          while(current!=null){
                Node next = current.next; //will be used to the continue the loop
                if(current.data >= k){
                      pivotnext.next = current;
                      pivotnext = current;
                      pivotnext.next = null;
                } else {
                      rootnext.next = current;
                      rootnext = current;
                }
                current = next;
            }
                  rootnext.next = pivot.next;
                  return root.next;
    }
    
    public Node partitionAroundWith2pointers(Node current, int k){
          Node newhead = current;
          Node tail = current;
          
          while(current!=null){
                Node next = current.next ; //will be used to the continue the loop
                if(current.data<k){
                      // add the current in front of k
                      current.next = newhead;
                      newhead = current;
                } else {
                      //add current at tail
                      tail.next = current;
                      tail = current;
                }
                current = next;
          }
          tail.next = null; //set the end of list to null
          return newhead;
    }
    
    public static void main(String args[])
    {
        PartitionList llist = new PartitionList();
            head = new Node(1);
            head.next = new Node(4);
            head.next.next = new Node(3);
            head.next.next.next = new Node(2);
            head.next.next.next.next = new Node(5);
            head.next.next.next.next.next = new Node(2);
            // head.next.next.next.next.next.next = new Node(1);
 
            System.out.println("Given list");
             llist.printList(head);
            Node newlist = llist.partitionAroundWith4pointers(3);
            // Node newlist = llist.partitionAroundWith2pointers(head, 3);

 
            System.out.println("Partitioned Linked List");
            llist.printList(newlist);
    }
    
    void printList(Node head)
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}