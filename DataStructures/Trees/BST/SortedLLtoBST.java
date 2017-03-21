/**
 * LOGIC:  
 * 1. Calculate the length of the list.
 * 2. Recursively construct the left subtree for n/2 nodes.
 * 3. Now create the root which will be head.
 * 4. Link the left subtree with the root.
 * 5. Change head to head.next for parents.
 * 6. Recursively construct the right subtree for remaining (n-n/2-1) nodes.
 * 7. Link the right subtree with the root.
 * 8. Return root.
 * */
import java.util.*;
class ListNode{
      int data; 
      ListNode next;
      ListNode(int data){
            this.data = data;
      }
}

public class SortedLLtoBST{
    ListNode head;
    public static void main(String args[]){
        SortedLLtoBST obj = new SortedLLtoBST();
        
        obj.head = new ListNode(2);
        obj.head.next = new ListNode(3);
        obj.head.next.next = new ListNode(7);
        obj.head.next.next.next = new ListNode(9);
        obj.head.next.next.next.next = new ListNode(12);
        obj.head.next.next.next.next.next = new ListNode(14);
        obj.head.next.next.next.next.next.next = new ListNode(16);
        obj.head.next.next.next.next.next.next.next = new ListNode(19);
        obj.head.next.next.next.next.next.next.next.next = new ListNode(20);
        obj.head.next.next.next.next.next.next.next.next.next = new ListNode(23);
        obj.head.next.next.next.next.next.next.next.next.next.next = new ListNode(30);
        
        Node root = obj.createBST(obj.head);
        obj.inorder(root);
         
        /**
		 * 
		 * 		      16 
		                /    \
	* 		         12     20
	*                   / \    /  \ 
	*                  7  14  19  23
	* 			/ \	        \
	*                3  9           30
		 *        /
		 *       2          
		 */
		 
    }
    
    public Node createBST(ListNode head){
           /*Count the number of nodes in Linked List */
            int n = countNodes(head);
            return createBSTHelper(n);
    }
    
    public Node createBSTHelper(int n){
          System.out.println("Processing "+n);
          /* Base Case */
        if (n <= 0) 
            return null;
            
        /* Recursively construct the left subtree */
        Node left = createBSTHelper(n/2);
        
        /*Now create the root which will be head*/
        Node root = new Node(head.data);
        
        /*Link the left subtree with the root*/
        root.left = left;
        
        /* Change head pointer of Linked List for parent recursive calls */
        head = head.next;
        
        /* Recursively construct the left subtree */
        Node right = createBSTHelper(n - n/2 - 1);
        
        /*Link the right subtree with the root*/
        root.right = right;
        
        return root;
        
    }
    
    int countNodes(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    
    public void inorder(Node root){
          if(root.left!=null) inorder(root.left);
          System.out.print(" "+root.key);
          if(root.right!=null) inorder(root.right);
    }
    
   
}