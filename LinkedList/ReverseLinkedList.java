public class ReverseLinkedList{
    
    public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    Node current=null;
    Node head,previousNode,nextNode =null;
    int nodeLength =0;
    
    public static void main(String args[]){
       
       ReverseLinkedList reverselistobj = new ReverseLinkedList();
       /**
        * First prepare a linkedlist. 
        * Insert values from the End.
        **/
        reverselistobj.insertAtEnd(100);
        reverselistobj.insertAtEnd(200);
        reverselistobj.insertAtEnd(300);
        reverselistobj.insertAtEnd(400);
        reverselistobj.printLinkedList();
        
        System.out.println("\n\n++List after rotating++");
        reverselistobj.reverseLinkedList();
        reverselistobj.printLinkedList();
    }
    
    
    public void reverseLinkedList(){
        current = head;
        while(current.next!=null){
            //1. Start with the next node
               nextNode = current.next;
            //2. Rotate the list
               current.next = previousNode;
            //3. moving currentNode and previousNode by 1 node
			  previousNode = current;
			  current = nextNode;
        }
      
        head = current;
        current.next = previousNode;
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