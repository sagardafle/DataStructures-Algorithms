/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        //null check
        if(lists==null||lists.length==0)
        return null;
        
        // a prioirty queue with comparator for sorting
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
            return l1.val - l2.val;
        }
        });
        
       ListNode head = new ListNode(0);
       ListNode p = head;
 
    // add the lists to the queue
    for(ListNode list: lists){
        if(list!=null)
            pq.offer(list);
    }    
    
    /**
     * remove the elements from PQ and keep on adding it to the next of the head.
     */ 
    while(!pq.isEmpty()){
       p.next = pq.poll();
      p=p.next;
      
       if(p.next!=null)
            pq.offer(p.next);
    }
    return head.next;
}
}