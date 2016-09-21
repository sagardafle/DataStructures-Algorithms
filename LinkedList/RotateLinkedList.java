public class RotateLinkedList {
      Node head;  // head of list
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
    
    void rotate(int k){
        Node temp = head;
        int i=1;
        while(i<k){
            temp = temp.next;
            i++;
        }
        Node initialhead = head;
        head = temp.next;
        Node lastnode = temp;
       while(temp.next!=null){
           temp = temp.next;
       }
       temp.next = initialhead;
       lastnode.next = null;
    }
      void printList()
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
    
    public static void main(String args[])
    {
        RotateLinkedList llist = new RotateLinkedList();
 
        // create a list 10->20->30->40->50->60
        for (int i = 60; i >= 10; i -= 10)
            llist.push(i);
 
        System.out.println("Given list");
        llist.printList();
 
        llist.rotate(3);
 
        System.out.println("Rotated Linked List");
        llist.printList();
    }
}