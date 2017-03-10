class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
public class SumListsOriginal {
    
    static Node l1, l2 ,newhead;
    static int carry = 0;
    public static void main(String[] args) {
        l1 = new Node(1);
        l1.next = new Node(2);
        l1.next.next = new Node(3);
        l1.next.next.next = new Node(4);

        l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(7);
        
        newhead = null;
        SumListsOriginal sumoriginal = new SumListsOriginal();

        Node newList = sumoriginal.sumLists(l1, l2);
        sumoriginal.printList(newList);
    }
    
    public Node sumLists(Node l1, Node l2){
          return sumListsHelper(l1,l2,0);
    }
    
    public Node sumListsHelper(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) return null;
        
        /* get lengths of the list */
        int l1length = getLength(l1);
        int l2length = getLength(l2);
        
        /* get the diffrence of the length and pad 0's accordingly */
        int nodediff = Math.abs(l1length-l2length);
        Node paddednode = null;
        if(nodediff>0) {
              paddednode = l1length<l2length ? padZeros(l1,nodediff) : padZeros(l2,nodediff);
        }
        Node sumlist = null;
        if(l1length<l2length) {
             sumlist =  sumEqualLists(paddednode,l2);
        } else {
             sumlist =  sumEqualLists(l1,paddednode);
        }
        return sumlist;
    }
    
    public Node sumEqualLists(Node n1, Node n2){
        if(n1== null && n2==null) return null;
        Node result = null;
        Node temp = null;
        int nodeval = 0;
        
               temp = sumEqualLists(n1.next, n2.next);
               System.out.println("adding "+n1.data+" and "+n2.data);
               nodeval = carry + n1.data +n2.data;
               carry = nodeval/10;
               System.out.println("Nodeval is==== "+nodeval%10);
               result = new Node(nodeval%10);
               insertBefore(result);
        
        return newhead;
    }
    
    public void insertBefore(Node temp){
          if(newhead == null) {
                newhead = temp;
          } else {
                temp.next = newhead;
                newhead = temp;
          }
          
    }
    
    public int getLength(Node node){
          int length =0;
          if(node == null) return length;
          while(node!=null){
                length +=1;
                node = node.next;
          }
          return length;
    }
    
    public Node padZeros(Node node, int noOfZeros){
          int i=0;
          Node newNode = null;
          while(i<noOfZeros){
                newNode = new Node(0);
                newNode.next = node;
                i++;
          }
          return newNode;
    }
    
    void printList(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"-> ");
            temp = temp.next;
        }
        System.out.println();
    }
}