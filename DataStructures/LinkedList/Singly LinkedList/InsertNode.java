public class InsertNode {
    
    /**
     * A LinkedList contains of single or multiple "NODES".
     * Each Node can be considered as a class. 
     * A Node comprises of : 
     *  - Data : a value for each node.
     *  - Next : pointer to the next node.
     * Implementation of a single node class
     */
     public class Node{
         int data;
         Node next;
         Node (int newNode) {
         this.data = newNode;
         this.next = null;
        }
     }
    
     
     public int nodeLength =0;
     public Node current= null;
     public Node head = null;
     
     public static void main(String args[]){
        InsertNode insnode = new InsertNode();
        
        /**
         * 1. insertAtEnd adds a node at the end of the LinkedList
        **/
                 insnode.insertAtEnd(10);
                 insnode.insertAtEnd(20);
                 insnode.insertAtEnd(30);
                 insnode.insertAtEnd(40);
                 insnode.printLinkedList();
        
        /**
         * 2. insertAtBegin adds a node at the beginning of the LinkedList
        **/ 
        
          //       insnode.insertAtBegin(10);
          //       insnode.insertAtBegin(20);
          //       insnode.insertAtBegin(30);
          //       insnode.insertAtBegin(40);
          //       insnode.printLinkedList();
                
        /**
         * 3. insertAtIndex(data,index) add a node at the specified index 
         */
            //   insnode.insertAtIndex(100,3);
            //   insnode.printLinkedList();
    }
    
    public void insertAtEnd(int nodeData){
        Node newNode = new Node(nodeData);
        if(head == null) head = newNode;
          else {  Node current = head;
                  while(current!=null && current.next!=null){
                            current = current.next;
                  }
                  current.next = newNode;
        }
    }
    
    
    public void insertAtBegin(int nodeData){
          Node newNode = new Node(nodeData);
         if(head == null) head = newNode;
          else {
                    newNode.next = head;
                    head = newNode;
          }
    }
    
    public void insertAtIndex(int nodeData,int insertionindex){
        System.out.println("\n\nAfter inserting "+nodeData+" at "+insertionindex);
         if(insertionindex > nodeLength){
             // The index specified is incorrect. Add the value in the beginning of the list.
             insertAtBegin(nodeData);
         }
         Node newNodeToBeAdded =  new Node(nodeData);
         current = head;
         int counter=1;
         while(current!=null && counter<insertionindex-1){
             current = current.next;
             counter++;
         }
         Node temp = current.next;
         current.next = newNodeToBeAdded;
         newNodeToBeAdded.next = temp;
         nodeLength++;
    }
    
    public void printLinkedList(){
        System.out.println("=====Length of the List===== " +nodeLength);
        if(head!=null){
            current = head;
            System.out.println("\n=======Printing the List======");
        while(current!=null){
          System.out.print(current.data +" -> ");
          current = current.next;
         }
        }
    }
}