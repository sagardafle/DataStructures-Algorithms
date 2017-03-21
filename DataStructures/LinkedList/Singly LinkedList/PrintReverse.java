/**
 * Given a linked list, print reverse of it using a recursive function. 
 * For example, if the given linked list is 1->2->3->4, then output should be 4->3->2->1.
*/

public class PrintReverse {

    public class Node {
        int data;
        Node next;
        Node(int newData) {
            this.data = newData;
            this.next = null;
        }
    }

    public int nodeLength = 0;
    public Node current = null;
    public static Node head = null;

    public static void main(String args[]) {
        PrintReverse printreverseobj = new PrintReverse();

        printreverseobj.addNode(11);
        printreverseobj.addNode(11);
        printreverseobj.addNode(11);
        printreverseobj.addNode(21);
        printreverseobj.addNode(43);
        printreverseobj.addNode(43);
        printreverseobj.addNode(60);
        printreverseobj.printLL();
        System.out.print("Reversed List \n");
        
        printreverseobj.printReverseLL(head);
        
    }

    public void printReverseLL(Node head){
       if(head.next != null) printReverseLL(head.next);
           System.out.print(head.data+" ");
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
        nodeLength += 1;
    }
}