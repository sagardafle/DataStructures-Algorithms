/**
 * LOGIC : 
 * 1.Traverse the list using Floyd's algorithm. 
 * 2. If fast!=null and fast = slow , it means there's a loop.
 **/
public class IsCyclic {
    
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
    Boolean isCyclic = false;
    int nodeLength =0;
    Node slow = null;
    Node fast = slow;
    public static void main(String args[]){
         IsCyclic cyclicobj = new IsCyclic();
         cyclicobj.preparelist();
       
        //cyclicobj.printLinkedList();
        System.out.println("\nIsCyclic "+cyclicobj.checkIfCyclic());
    }
    
    public void preparelist(){
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = head;   //--> points to head.So it is cyclic.
    }
    
    public boolean checkIfCyclic(){
        slow = head;
        fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
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