public class DeleteNodeWithSinglePointer{
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
    public static void main(String args[]){
        DeleteNodeWithSinglePointer deletenodeobj = new DeleteNodeWithSinglePointer();
        deletenodeobj.prepareLists();
        deletenodeobj.printLinkedList(head);
        deletenodeobj.deletenodeSinglePointer(head.next.next); //30 
        deletenodeobj.printLinkedList(head);
     }
     
     public void deletenodeSinglePointer(Node nodeToBeDeleted){
         if(nodeToBeDeleted!=null){ //check for null condition
             current = head;
         while(current.next !=nodeToBeDeleted){ //traverse till we reached before the nodeToBeDeleted
             current = current.next;
         }
         current.next = nodeToBeDeleted.next; //set the current.next to node to be deleted's next thereby bypassing this node.
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
