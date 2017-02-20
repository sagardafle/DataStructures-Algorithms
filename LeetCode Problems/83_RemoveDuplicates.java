/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // if(head == null || head.next == null) return head; 
        // head.next = deleteDuplicates(head.next);
        // return head.next.val == head.val ? head.next : head;
        if(head == null || head.next == null) return head;
        ListNode current = head;
        while(current!=null && current.next!=null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }