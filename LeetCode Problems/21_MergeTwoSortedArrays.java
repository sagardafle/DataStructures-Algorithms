/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /**
  * LOGIC1 : Using Priority Queue. Make use of the same logic as to merge "K" linked list. https://github.com/sagardafle/DataStructures-Algorithms/blob/master/LeetCode%20Problems/23_MergeKSortedLists.java
  */ 
  /**
   * LOGIC2: : Run a loop and keep comparing elements one by one.
   */ 
public class Solution {
   
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         /** LOGIC 1:
        ListNode[] lists = {l1,l2};
        
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
    
    
     remove the elements from PQ and keep on adding it to the next of the head.
      
    while(!pq.isEmpty()){
       p.next = pq.poll();
      p=p.next;
      
       if(p.next!=null)
            pq.offer(p.next);
    }
    return head.next;
    }
    */
    
    
    /**LOGIC2: Run a loop and keep comparing elements one by one.
     */ 
     ListNode dummy = new ListNode(0);
        ListNode k = dummy;
     while(l1!=null && l2!=null){
             if(l1.val <= l2.val){
                 k.next = l1;
                 l1 = l1.next;
             } else {
                 k.next = l2;
                 l2 = l2.next;
             }
             k = k.next;
     }
         
          if (l1 == null) // add l2 to k.next
        	k.next = l2;
        if (l2 == null)   // add l1 to k.next
        	k.next = l1;
         
     return dummy.next;
     
    }
}