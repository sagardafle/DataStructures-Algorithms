/**
 * Logic 1 
 * 1: Traverse both the list. 
 * 2: Compute length. Compute diffrence = largerlist-shorterlist
 * 3: Traverse the bigger list till 'diff' iterations.
 * 4: Now, traverse both the list parallely. 
 * 5: If a match is found, that is the intersection point.
 * 
 * 
 * Logic 2 (This method is only to detect if there is an intersection point or not.)
 * 1: Traverse list1 . Store pointer to last node of list1.
 * 2: Traverse list2 . Store pointer to last node of list2.
 * 3: If the above two pointers meet, there is an intersection.
 * 
 * 
 * Logic 3 (Use Hashing)
    Basically we need to find common node of two linked lists. So we hash all nodes of first list and then check second list.
   1: Create an empty hash table such that node address is used as key and a binary value present/absent is used as value.
   2: Traverse the first linked list and insert all nodes’ addresses in hash table.  
   3: Traverse the second list. For every node check if it is present in hash table. If we find a node in hash table, return the node.
 * 
 * 
 **/
 
 import java.util.*;
public class InterSectionOfTwoLists{
    public class Node{
        int data;
        Node next;
        Node(int nodeData){
            this.data = nodeData;
            this.next = null;
        }
    }
    
    static Node head1 = null;
    static Node head2 = null;
    Node current = null;
    public static void main(String args[]){
        InterSectionOfTwoLists intersectionobj = new InterSectionOfTwoLists();
        intersectionobj.prepareLists();
        intersectionobj.printLinkedList(head1);
        intersectionobj.printLinkedList(head2);
        System.out.println("\nIntersection point: "+intersectionobj.findintersectionpoints());
    }
    
    
    public int findintersectionpoints(){
        /**
         * LOGIC 1
         * 
        int list1length = 0;
        int list2length = 0;
        current = head1;
        while(current!=null){
            current = current.next;
            list1length +=1;
        }
        current = head2;
        while(current!=null){
            current = current.next;
            list2length +=1;
        }
        int diff = (list1length > list2length) ? (list1length-list2length) : (list2length-list1length);
        int i=0;
        current = (list1length > list2length) ? head1:head2; //move the longer list by 'diff' length
        while(i<diff){
            i++;
            current = current.next;
        }
        
        Node temp = (list1length < list2length) ? head1:head2;  //set it to shorter list
        while(current!=null && temp!=null){
            if(current.data == temp.data) return current.data;
            current = current.next;
            temp = temp.next;
        }
        return -1;
        **/
        
        /**
         * Logic 3
         **/
         HashSet <Integer> newset = new HashSet <Integer>();    
         current = head1;
         while(current!=null){
                    newset.add(current.data);
                    current = current.next;
             }
         current = head2; 
          while(current!=null){
              if(newset.contains(current.data)){
                  break;
              } else {
                  newset.add(current.data);
                  current = current.next;
              }
             }
        return current.data;
    }
    
    
     public void prepareLists(){
        head1 = new Node(3);
        head1.next = new Node(6);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(15);
        head1.next.next.next.next = new Node(30);   
        
        head2 = new Node(10);
        head2.next = new Node(15);
        head2.next.next = new Node(30);
    }
   
    
    public void printLinkedList(Node head){
       // System.out.println("=====Length of the List===== " +nodeLength);
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