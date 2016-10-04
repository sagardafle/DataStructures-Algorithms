public class DetectLoop {
        
        public static class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    Node current=null;
    static Node head;
    int nodeLength =0;
    
    public static void main(String args[]){
       
       DetectLoop detectloopobj = new DetectLoop();
       /**
        * First prepare a linkedlist. 
        * Insert values from the End.
        **/
        head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = head.next.next; //30
        //detectloopobj.printLinkedList();
    
        if(detectloopobj.hasLoop(head)){
            System.out.println("Loop detected");
        } else {
            System.out.println("No Loop detected");
        }
        
    }
    
    public static boolean hasLoop(Node current){
        if(current == null) return false; //List is empty,so no loop.
        if(current.next == null) return false; //Only one element in the list, so no loop.
        
        Node slow,fast; //two references
        slow = fast = current; //Initially both the pointers point to the HEAD.
        
        while(true){
            slow = slow.next;           // 1 hop
            if(fast.next!=null){
                fast = fast.next.next;  //2 hops
            } else{
                return false;   // next node null => no loop.
            }
            
            if(slow == null || fast == null){
                return false;
            }  
                   
            
            if(slow == fast) return true;
        }
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