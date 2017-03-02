public class DelteNodeSinglePointer{
    static Node head; // head of the list
 
    /* Linked List node */
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    
    public static void main(String args[]) {
        DelteNodeSinglePointer deletenode = new DelteNodeSinglePointer();
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        deletenode.printLL(head);
        System.out.print("\n List after deleting node \n");
        deletenode.deletenodewithsinglepointer(head.next.next.next); //40
        deletenode.printLL(head);
    }
    /**
     * Limitation : We cannot delete the last node in the list. 
     */ 
     public void deletenodewithsinglepointer(Node n) {
         if(n==null) return;
         n.data = n.next.data;
         n.next = n.next.next;
     }
     public void addNode(int newData) {

        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printLL(Node head) {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
    }
}
    