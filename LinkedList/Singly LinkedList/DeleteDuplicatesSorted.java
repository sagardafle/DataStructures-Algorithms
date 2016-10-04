/**
 * http://www.geeksforgeeks.org/remove-duplicates-from-a-sorted-linked-list/
 * Write a removeDuplicates() function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list. The list should only be traversed once.

For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.

LOGIC : Keep current to head. 
Check if the next node's data is same as the current's data. 
If YES, change current.next to current.next.next.
else simply continue iterate throught the list 
*/

public class DeleteDuplicatesSorted {

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
    public Node head = null;

    public static void main(String args[]) {
        DeleteDuplicatesSorted delduplicatesortedlist = new DeleteDuplicatesSorted();

        delduplicatesortedlist.addNode(11);
        delduplicatesortedlist.addNode(11);
        delduplicatesortedlist.addNode(11);
        delduplicatesortedlist.addNode(21);
        delduplicatesortedlist.addNode(43);
        delduplicatesortedlist.addNode(43);
        delduplicatesortedlist.addNode(60);
        delduplicatesortedlist.printLL();
        System.out.print("List after deleting duplicates \n");
        delduplicatesortedlist.removeDuplicates();
        delduplicatesortedlist.printLL();
    }

    public void removeDuplicates() {
        if (head == null) return;
        Node next_next = null;
        Node current = head;
        while (current.next != null) {
            if (current.data == current.next.data) {
                next_next = current.next.next;
                current.next = next_next;
                nodeLength -= 1;
            } else {
                current = current.next;
            }
        }
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

    public void printLL() {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.println("\n NodeLength: " + nodeLength);
    }


}