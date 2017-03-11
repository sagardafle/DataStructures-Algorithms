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
 
    Node mergeSort(Node head){
        /* Base case -- length 0 or 1 */
        if(head == null || head.next == null){
            return head;
        }
        //get middle node for Split head into 'a' and 'b' sublists 
        Node mid = getMidNode(head);
 
        Node a = head;//firstList
        Node b = mid.next;//secondList
        mid.next = null;
 
        /* Recursively sort the sublists */
        mergeSort(a);
        mergeSort(b);
 
        /* answer = merge the two sorted lists together */
        head = SortedMerge(a,b);
 
        return head;
    }
    Node getMidNode(Node head){
        Node slow = head;
        Node fast = head.next;
 
        while(fast != null && fast.next != null){
            slow =slow.next;
            fast =fast.next.next;
        }
        return slow;
    }
 
    Node SortedMerge(Node a,Node b){
        Node result = null;
        /* Base cases */
        if (a == null) 
            return(b);
        else if (b==null) 
            return(a);
 
        /* Pick either a or b, and recur */
        if (a.data <= b.data) {
            result = a;
            result.next = SortedMerge(a.next, b);
        }
        else{
            result = b;
            result.next = SortedMerge(a, b.next);
        }
        return(result);
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
 
        llist.head = llist.mergeSort(llist.head); 
        llist.printList(llist.head);
 
    }
} 