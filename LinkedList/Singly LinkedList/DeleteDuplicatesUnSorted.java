/**
 * http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
 * Write a removeDuplicates() function which takes a list and deletes any duplicate nodes from the list. The list is not sorted.

For example if the linked list is 12->11->12->21->41->43->21 then removeDuplicates() should convert the list to 12->11->21->41->43


LOGIC :
*/
import java.util.*;
public class DeleteDuplicatesUnSorted {

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
        DeleteDuplicatesUnSorted delduplicateunsortedlist = new DeleteDuplicatesUnSorted();

        delduplicateunsortedlist.addNode(12);
        delduplicateunsortedlist.addNode(11);
        delduplicateunsortedlist.addNode(12);
        delduplicateunsortedlist.addNode(21);
        delduplicateunsortedlist.addNode(43);
        delduplicateunsortedlist.addNode(43);
        delduplicateunsortedlist.addNode(21);
        delduplicateunsortedlist.printLL(head);
        System.out.print("List after deleting duplicates \n");
        delduplicateunsortedlist.removeDuplicates();
        //delduplicateunsortedlist.printLL(head);
    }

    public void removeDuplicates() {
        if (head == null) return;
        /**
         * METHOD -1 : Use two loops. Outer loop to keep a track of the current node. 
         * Inner loop to compare each node with the outer loop's current node.
         */
         
        //  Node current = head;
        //  Node reference = current.next;
        //  Node temp = null;
        //  while(current.next!=null){
        //      while(reference!=null){
        //          if(reference.data == current.data){
        //              temp = reference;
        //              current.next = reference.next;
        //              reference = reference.next;
        //              nodeLength -= 1;
        //          } else {
        //              current.next = reference;
        //              reference = reference.next;
        //          }
        //      }
        //      current = current.next;
        //  }
        
        //Method-2 : Keep a Hashmap
         HashMap<Node,Integer> hs = new HashMap<Node,Integer>();
         Node current = head.next;
         Node temp = head;
         while(current!=null){
             if(!hs.containsKey(current)){
                 System.out.println("Adding "+current.data);
                 hs.put(current,1);
                 temp.next = current;
             } else {
                 current = current.next;
                // nodeLength -=1;
             }
            current = current.next;
         }
        
       Iterator it = hs.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            temp.next = (Node) pair.getKey();
            it.remove(); // avoids a ConcurrentModificationException
        }
        printLL(temp);
        
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

    public void printLL(Node head) {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.println("\n NodeLength: " + nodeLength);
    }


}