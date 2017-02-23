/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        Stack<Integer> s = new Stack();
        ListNode slowptr = head;
        ListNode fastptr = head;
        while(fastptr!=null && fastptr.next!=null){
            s.push(slowptr.val);
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
            
        }
        System.out.println("Stack "+s);
        if(fastptr!= null) slowptr = slowptr.next; // This means that the list is odd. So no need to add the middle element in Stack, 
                                                    //as that be present exactly once.
        while(s.size()>0 || slowptr!=null) {
            if(s.pop() != slowptr.val) return false;
            slowptr = slowptr.next;
        }
        return true;
    }
}