import java.util.*;
public class RemoveDuplicates {

    public class Node {
        int data;
        Node next;
        Node(int newData) {
            this.data = newData;
            this.next = null;
        }
    }

    public int nodeLength = 0;
    public Node current = null;
    public static Node head = null;

    public static void main(String args[]) {
        RemoveDuplicates delduplicateunsortedlist = new RemoveDuplicates();

        delduplicateunsortedlist.addNode(12);
        delduplicateunsortedlist.addNode(12);
        delduplicateunsortedlist.addNode(11);
        delduplicateunsortedlist.addNode(12);
        delduplicateunsortedlist.addNode(21);
        delduplicateunsortedlist.addNode(43);
        delduplicateunsortedlist.addNode(43);
        delduplicateunsortedlist.addNode(21);
        delduplicateunsortedlist.printLL(head);
        System.out.print("\n List after deleting duplicates \n");
        //delduplicateunsortedlist.removeDuplicatesUnOptimized();
        delduplicateunsortedlist.removeDuplicatesOptimized();
        delduplicateunsortedlist.printLL(head);
    }
    /**
     * Very imp point : Inner node pointer(temp) should be always set to outer node pointer(reference) at the beginning of each iteration. line 42.
     */ 
    public void removeDuplicatesUnOptimized(){
        Node reference = head;
        Node temp = null;
        while(reference!=null){
            System.out.println("Reference========= "+reference.data);
            temp = reference;
            while(temp.next!=null){
                System.out.println("Temp -  "+temp.data);
                if(temp.next.data == reference.data){
                     System.out.println("Removing  "+temp.next.data+ " from the list");
                    temp.next = temp.next.next;
                    nodeLength -=1;
                } else{
                     temp = temp.next;
                }
            }
            reference = reference.next;
        }
    }
    
    /**
     * LOGIC:   1. Create a Hash Table.Add the head data to it.
                2. Take two pointers, prevNode and CurrNode.
                3. PrevNode will point to the head of the linked list and currNode will point to the head.next.
                4. Now navigate through the linked list.
                5. Check every node data is present in the HashTable.
                6. if yes then delete that node using prevNode and currNode.
                7. If No, then insert that node data into the linked list
     */
     
    public void removeDuplicatesOptimized(){
         if(head==null){
            return ;
        }
        HashSet<Integer> ht = new HashSet<Integer>();
        Node prevNode = head;
        Node currNode = head.next;
       
        ht.add(head.data); // add the first element as it is to the hashset.
        while(currNode!=null){
            int data = currNode.data;
            if(ht.contains(data)){
                prevNode.next = currNode.next;
                currNode = currNode.next;
            }else{
                ht.add(data);
                prevNode = currNode;
                currNode = currNode.next;
            }
        }
    }
        
    //   for (Integer val : hs) {
    //         System.out.print(val+" -> ");
    //     }
    
    
    public void addNode(int newData) {

        Node newNode = new Node(newData);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        nodeLength += 1;
    }

    public void printLL(Node head) {
        if (head == null) return;
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.data);
            current = current.next;
        }
        System.out.println("\n NodeLength: " + nodeLength);
    }
}