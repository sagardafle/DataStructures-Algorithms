public class DeleteNode {
    //properties
    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    private int length;

    //Create a new empty list
    public DeleteNode() {
        head = new DoublyLinkedList(Integer.MIN_VALUE, null, null);
        tail = new DoublyLinkedList(Integer.MIN_VALUE, null, null);
        head.setNext(tail);
        length = 0;
    }

    //Get value at current position
    public int get(int position) {
        return Integer.MIN_VALUE;
    }

    //Find the position of the node value that is equal to the specified value. 
    public int getPosition(int data) {
        DoublyLinkedList temp = head;
        int pos = 0;
        while (temp != null) {
            if (temp.getData() != data) {
                pos += 1;
                temp = temp.getNext();
            } else {
                // as the specific node is found, return it.
                return pos;
            }
        }
        return Integer.MIN_VALUE;
    }

    //Return current lengthof Doubly LinkedList
    public int length() {
            return length;
        }
        //Remove value at given position
    public void remove(int position) {
        //fix position
        if (position < 0) {
            position = 0;
        }
        if (position >= length) {
            position = length - 1;
        }
        if (head == null)
            return;

        //if the head is to be removed
        if (position == 0) {
            head = head.getNext();
            if (head == null) tail = null;
        }
        // else locate correct position and remove
        else {
            DoublyLinkedList temp = head;
            for (int i = 0; i <= position; i += 1) {
                temp = temp.getNext();
            }
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
        }
        //finally reduce length by 1
        length -= 1;
    }

//Remove a node that matches specified node

public void removeThisNode(DoublyLinkedList node) {
    if (head == null) return;
    if (node.equals(head)) {
        head = head.getNext();
        if (head == null) tail = null;
        return;
    }
    DoublyLinkedList p = head;
    while (p != null) {
        if (node.equals(p)) {
            p.prev.next = p.next;
            p.next.prev = p.prev;
            return;
        }
    }
}

//Remove Head value from the list.
public int removeHead() {
    if (length == 0) return Integer.MIN_VALUE;
    DoublyLinkedList temp = head.getNext();
    head.setNext(temp.getNext());
    temp.getNext().setPrev(head);
    length -= 1;
    return temp.getData();
}

//Remove Tail value from the list.
public int removeTail() {
    if (length == 0) return Integer.MIN_VALUE;
    DoublyLinkedList temp = tail.getPrev();
    tail.setPrev(temp.getPrev());
    temp.getPrev().setNext(tail);
    length -= 1;
    return tail.getData();
}
}