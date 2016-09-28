public class DoublyLinkedList {
    private int data; //value of each node
    public DoublyLinkedList prev; // pointer to previous node
    public DoublyLinkedList next; //pointer to next node

    public DoublyLinkedList(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public DoublyLinkedList(int data, DoublyLinkedList prev, DoublyLinkedList next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DoublyLinkedList getPrev() {
        return prev;
    }

    public DoublyLinkedList getNext() {
        return next;
    }

    public void setPrev(DoublyLinkedList where) {
        prev = where;
    }
    public void setNext(DoublyLinkedList where) {
        next = where;
    }
}