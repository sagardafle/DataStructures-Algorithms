/**
 * LOGIC
 *  1) Store the mid and last pointers of the circular linked list using tortoise and hare algorithm.
    2) Make the second half circular.
    3) Make the first half circular.
    4) Set head (or start) pointers of the two linked lists.
 */ 
public class SplitCircularList{
    public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    static Node head1 = null;
    static Node head2 = head1;
    Node current = null;
    int nodeLength =0;
    public static void main(String args[]){
        SplitCircularList splitcircularlist = new SplitCircularList();
        splitcircularlist.prepareLists();
       // splitcircularlist.printLinkedList();
        splitcircularlist.splitthelist();
        //splitcircularlist.printLinkedList(head1);  //prints the first cyclic linkedlist 10->20->30->10
        splitcircularlist.printLinkedList(head2);    //prints the second cyclic linkedlist 40->50->40
    }
    
     public void splitthelist(){
         current = head1;
         Node mid = head1;
         Node last = head1;
         while(last.next!=null && last.next.next!=null){
             if(last.next == head1) break;
             mid = mid.next;
             last = last.next.next;
         }
         System.out.println("Mid "+mid.data);
         System.out.println("Last "+last.data);
         last.next = mid.next;
         head2 = last.next;
         mid.next = head1;
     }
     
     public void prepareLists(){
        head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);   
        head1.next.next.next.next.next = head1;   
        
    }
    
     public void printLinkedList(Node head){
        if(head!=null){
            current = head;
            System.out.println("=======Printing the List======");
        while(current!=null){
          System.out.print(current.data +" -> ");
          current = current.next;
         }
        }
    }
}
    
    
    