/**
 * LOGIC: 
 * 1. Start from the head node and traverse the list. 
 * 2. While traversing swap data of each node with its next node’s data.
 * */
public class ExchangeAdjacent {
      public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    static Node head = null;
    Node current = null;
    int nodeLength =0;
    public static void main(String args[]){
        ExchangeAdjacent exchangelements = new ExchangeAdjacent();
        exchangelements.prepareLists();
        exchangelements.exchangeAdjacentElements();
        exchangelements.printLinkedList(head);
    }
    
    public void exchangeAdjacentElements(){
        current = head;
       while(current.next !=null && current.next.next !=null){
           int temp = current.data;
           current.data = current.next.data;
           current.next.data = temp;
           current = current.next.next;
       }
    }
    
     public void prepareLists(){
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);   
        head.next.next.next.next.next = new Node(60);   
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