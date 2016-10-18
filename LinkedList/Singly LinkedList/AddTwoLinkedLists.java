public class AddTwoLinkedLists{
    public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    Node head1 = null;
    Node head2 = null;
    static Node head3 = null;
    Node current = null;
    Boolean isPalindrome = true;
    int nodeLength =0;
    public static void main(String args[]){
        AddTwoLinkedLists addllobj = new AddTwoLinkedLists();
        addllobj.prepareLists();
        addllobj.addTwoList();
         
        addllobj.printLinkedList(head3);
    }
    
    public void prepareLists(){
        head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);   
        
        
        head2 = new Node(60);
        head2.next = new Node(70);
        head2.next.next = new Node(80);
        head2.next.next.next = new Node(90);
        head2.next.next.next.next = new Node(100);  
    }
    
    public void addTwoList(){
        int sum =0;
        current = head1;
        while(current!=null){
            sum += current.data;
            current = current.next;
        }
        current = head2;
         while(current!=null){
            sum += current.data;
            current = current.next;
        }
        System.out.println(sum);
      head3 = new Node(sum%10);
      current = head3;
            sum /= 10;
        while(sum!=0){
            current.next = new Node(sum%10);
            current = current.next;
            sum /= 10;
        }
    }
    
   
    
    public void printLinkedList(Node head){
       // System.out.println("=====Length of the List===== " +nodeLength);
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