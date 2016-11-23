/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * LOGIC: 
 * 1. First, we shift a head of a list while its' value equals to val.
   2. Then, we iterate through the nodes of the list checking if the next node's value equals to val and removing it if needed.
*/ 
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
       while(head !=null &&  head.val == val) head = head.next; // Use case [1,1,1,4,6,7] if we need to delete 1, the head will be pointed to 4.
       ListNode curr = head;
       while(curr!=null && curr.next!=null){
           if (curr.next.val == val) curr.next = curr.next.next;
            else curr = curr.next;
       }
       return head;
    }
}