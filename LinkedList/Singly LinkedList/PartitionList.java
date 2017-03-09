public class PartitionList {
      static Node head;  // head of list
      int nodeLength=0;
 
    /* Linked list Node*/
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
     
      /*  Given a reference (pointer to pointer) to the head
        of a list and an int, push a new node on the front
        of the list. */
    void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
        ++nodeLength;
    }
    
    public Node partitionAround(int k){
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
    
    public static void main(String args[])
    {
        PartitionList llist = new PartitionList();
            llist.push(16);
            llist.push(5);
            llist.push(4);
            llist.push(13);
            llist.push(3);
            llist.push(2);
            
 
        System.out.println("Given list");
        llist.printList(head);
 
        Node newlist = llist.partitionAround(13);
 
        System.out.println("Rotated Linked List");
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
        System.out.println("nodeLength "+nodeLength);
    }
}