/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
       // return reverseListIterative(head);
        return reverseListRecursive(head);
    }
    
    /**
     * RECURSIVE
     */
     public ListNode reverseListRecursive(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode newhead = reverseListRecursive(head.next); // reach till the end of the list.
        head.next.next = head; // reverse the pointers (making double pointers)
        head.next = null; // remove the forward pointer.
        return newhead; // the tail element of the list.
     }
  
    /**
     * ITERATIVE : 3 pointers 
     */ 
    public ListNode reverseListIterative(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode current, previousNode, nextNode;
        current = nextNode = head;
        previousNode = null;
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
        return head;
    }
}