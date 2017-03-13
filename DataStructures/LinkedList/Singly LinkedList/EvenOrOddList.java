/**
 * Traverse the linkedlist with 2x speed.
 * If the list is odd , the last pointer will be to the last element in the list.
   If the list is even, the last pointer will be to null.
 */
public class EvenOrOddList{
    public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    Node head1 = null;
    Node current = null;
    public static void main(String args[]){
        EvenOrOddList eveoddlinkedlist = new EvenOrOddList();
        eveoddlinkedlist.prepareLists();
        eveoddlinkedlist.printLinkedList();
        eveoddlinkedlist.checkIfEvenOrOdd();
    }
    
    public void checkIfEvenOrOdd(){
        //if the list is odd , the last pointer will be to the last element in the list.
        //if the list is even, the last pointer will be to null.
        current = head1;
        while(current!=null && current.next !=null){
            current = current.next.next;
        }
        if (current == null) System.out.println("\nThe list is even");
        else System.out.println("\nThe list is odd");
    }
    
    public void prepareLists(){
        head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);   
        head1.next.next.next.next.next = new Node(60); 
    }
    
     public void printLinkedList(){
        if(head1!=null){
            current = head1;
            System.out.println("=======Printing the List======");
        while(current!=null){
          System.out.print(current.data +" -> ");
          current = current.next;
         }
        }
    }
}