public class InsertNode {
    //properties
    private DoublyLinkedList head;
    private DoublyLinkedList tail;
    private int length;

    //Create a new empty list
    public InsertNode() {
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

    /**
     * CASE 1: Add a new value to the front of the list.(AFTER HEAD & BEFORE TAIL)
     */
    public void insertAtHead(int newValue) {
        DoublyLinkedList newNode = new DoublyLinkedList(newValue, head, head.getNext());
        newNode.getNext().setPrev(newNode);
        head.setNext(newNode);
        length += 1;
    }

    /**
     * CASE 2: Add a new value at a given position
     * */
    public void insertAtPosition(int data, int position) {
        //fix the position 
        if (position < 0) position = 0;
        if (position > length) position = length;

        //if the list is empty, this is going to be the only element in the list.
        if (head == null) {
            head = new DoublyLinkedList(data);
            tail = head;
        }
        //if the element is added at the front of list 
        else if (position == 0) {
            DoublyLinkedList temp = new DoublyLinkedList(data);
            temp.next = head;
            head = temp;
        }
        //locate the exact position and add the element now
        else {
            DoublyLinkedList temp = head;
            int i = 1;
            while (i < position) {
                temp = temp.getNext();
            }
            DoublyLinkedList newNode = new DoublyLinkedList(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            newNode.prev.next = newNode; // temp.next = newNode;
        }
        //finally increment the length
        length += 1;
    }

    /**
     * CASE 3: Add a node to the rear.(BEFORE TAIL)
     * */
    public void insertAtTail(int newValue) {
        DoublyLinkedList newNode = new DoublyLinkedList(newValue, tail.getPrev(), tail);
        newNode.getPrev().setNext(newNode);
        tail.setPrev(newNode);
        length += 1;
    }

    //String representation of the DLL

    public String toString() {
        String result = "[]";
        if (length == 0) return result;
        result = "[" + head.getNext().getData();
        DoublyLinkedList temp = head.getNext().getNext();
        while (temp != tail) {
            result += "," + temp.getData();
            temp = temp.getNext();
        }
        return result + "]";
    }

    public static void main(String args[]) {
        InsertNode insnodeobj = new InsertNode();
        insnodeobj.insertAtHead(15);
        insnodeobj.insertAtPosition(25, 1);
        insnodeobj.insertAtTail(35);
        System.out.println(insnodeobj.toString());
    }
}