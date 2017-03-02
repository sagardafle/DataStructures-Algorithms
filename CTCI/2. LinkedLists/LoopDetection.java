public class LoopDetection{
    static Node head;
    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    public static void main(String[] args){
        LoopDetection loopdetection = new LoopDetection();
        
        head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next = new Node(80);
        head.next.next.next.next.next.next.next.next = new Node(90);
        head.next.next.next.next.next.next.next.next.next = head.next.next; //pointing back to 30
        
        //loopdetection.printLL(head);
        Node loopstart = loopdetection.returnlooppoint(head);
        System.out.println("Loop starts at "+loopstart.data);
    }
    
    public Node returnlooppoint(Node head){
        Node slowptr = head;
        Node fastptr = head;
        
        while(fastptr!= null && fastptr.next!=null){
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            if(slowptr == fastptr) {
                Node collisionpoint = slowptr;
                System.out.println("Nodes collide at "+collisionpoint.data);
                break;
            }
        }
        slowptr = head; // move the slow pointer back to head.
        //now move both the slow pointers and fast pointers till they meet
        while(slowptr!=fastptr){
            slowptr = slowptr.next;
            fastptr = fastptr.next;
        }
        return fastptr;
    }
    
    public void printLL(Node curr){
        while(curr!=null){
            System.out.println(" " +curr.data);
            curr = curr.next;
        }
    }
}