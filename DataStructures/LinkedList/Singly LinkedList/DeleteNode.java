public class DeleteNode{
    
    public class Node{
        int data;
        Node next;
        
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    Node head,current = null;
    int nodeLength = 0;
    

    public static void main(String args[]){
       
       DeleteNode delnode = new DeleteNode();
       /**
        * First prepare a linkedlist. 
        * Insert values from the End.
        **/
        delnode.insertAtEnd(10);
        delnode.insertAtEnd(20);
        delnode.insertAtEnd(30);
        delnode.insertAtEnd(40);
        delnode.printLinkedList();
        
        // delnode.deletefromFront();
        // System.out.println("\n\n==After deleting from front==");
        // delnode.printLinkedList();
        
        delnode.deletefromRear();
        System.out.println("\n\n==After deleting from rear==");
        delnode.printLinkedList();
        
        // delnode.deletefromIndex(3);
        // System.out.println("\n\n==After deleting from specified index==");
        // delnode.printLinkedList();
        
        // delnode.deleteFromMiddle();
        // System.out.println("\n\n==After deleting from middle ==");
        // delnode.printLinkedList();
        
    }
    
    public void deletefromFront(){
        if(head == null) System.out.println("Nothing to delete as the list is empty");
        head = head.next;
        nodeLength --;
    }
    
    public void deletefromRear(){
       if(head == null) System.out.println("Nothing to delete as the list is empty");
       Node current = head;
       while(current!=null && current.next.next!=null){
           current = current.next;
       }
       current.next = current.next.next;
    }
    
    public void deletefromIndex(int removalindex){
        if(removalindex > nodeLength) return;
        int counter = 1;
        current = head;
        while(current.next!=null && counter != removalindex-1){
            current = current.next;
            counter++;
        }
        current.next = current.next.next;
        nodeLength--;
    }
    
    public void deleteFromMiddle(){
        int index = (nodeLength%2==0)? nodeLength/2-1 : nodeLength/2 ;
        int i=1;
        current = head;
        while(++i<index){
            current = current.next;
        }
        current.next = current.next.next;
        nodeLength--;
    }
    
     public void insertAtEnd(int nodeData){
        Node newNodeToBeAdded = new Node(nodeData);
        if(nodeLength == 0){
            head = newNodeToBeAdded;
            current = head;
            current.next = null;
            nodeLength++;
        }else{
            current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newNodeToBeAdded;
            newNodeToBeAdded.next = null;
             nodeLength++;
        }
    }
    
    public void printLinkedList(){
        System.out.println("=====Length of the List===== " +nodeLength);
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