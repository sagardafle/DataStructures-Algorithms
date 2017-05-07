// Java program merge sort linked list
class Node { 
    int data;
    Node next;
 
    Node(int d) {
        data = d;
        next = null;
    }
}
class SortLinkedList{
 
    Node head;  // head of list
 
    public Node sortList(Node head) {
    if (head == null || head.next == null)
      return head;
        
    // step 1. cut the list to two halves
    Node prev = null, slow = head, fast = head;
    
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    
    prev.next = null;
    
    // step 2. sort each half
    Node l1 = sortList(head);
    Node l2 = sortList(slow);
    
    // step 3. merge l1 and l2
    return merge(l1, l2);
  }
  
  Node merge(Node l1, Node l2) {
    Node l = new Node(0), p = l;
    
    while (l1 != null && l2 != null) {
      if (l1.data < l2.data) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
        p = p.next;
    }
    
    if (l1 != null)
      p.next = l1;
    
    if (l2 != null)
      p.next = l2;
    
    return l.next;
  }
 
    /* Inserts a new Node at front of the list. */
    public void push(int new_data)
    {
        /* 1 & 2: Allocate the Node &
                  Put in the data*/
        Node new_node = new Node(new_data);
 
        /* 3. Make next of new Node as head */
        new_node.next = head;
 
        /* 4. Move the head to point to new Node */
        head = new_node;
    }
    
    // prints content of double linked list
    void printList(Node head) {
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    /* Drier program to test above functions */
    public static void main(String args[])
    {
        SortLinkedList llist = new SortLinkedList();
 
        llist.push(15);
        llist.push(10);
        llist.push(5);
        llist.push(20);
        llist.push(3);
        llist.push(2);
 
        llist.head = llist.sortList(llist.head); 
        llist.printList(llist.head);
 
    }
} 