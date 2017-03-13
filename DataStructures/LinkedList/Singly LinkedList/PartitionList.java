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
    
    public Node partitionAroundWith2pointers(Node node, int k){
          Node head = node;
          Node tail = node;
          
          while(node!=null){
                Node next = node.next ; //will be used to the continue the loop
                if(node.data<k){
                      // add the node in front of k
                      node.next = head;
                      head = node;
                } else {
                      tail.next = node;
                      tail = node;
                }
                node = next;
          }
          tail.next = null; //set the end of list to null
          return head;
    }
    
    public static void main(String args[])
    {
        PartitionList llist = new PartitionList();
            llist.push(9);
            llist.push(8);
            llist.push(3);
            llist.push(7);
            llist.push(1);
            llist.push(4);
            
 
        System.out.println("Given list");
        llist.printList(head);
        Node newlist = llist.partitionAroundWith4pointers(7);
        //Node newlist = llist.partitionAroundWith2pointers(head, 7);
        
 
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