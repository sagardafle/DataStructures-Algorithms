/***
 * 1. Create a queue.
 * 2. Add root to the queue.
 * 3. While q size >0 : 
 *   a. Poll an element from queue.
 *   b. Push its left and right child into queue.
 */ 
import java.util.*;
public class LevelOrderTraversal{
    Node root;
    
    public static void main(String args[]){
        LevelOrderTraversal obj = new LevelOrderTraversal();
        
         
        /**
		 * 
		 * 		     1 
		                / \
	* 		         2    3
	*                   / \  / \ 
	*                  7  6  5  4
	* 			/ \	     \
	*                8  9       23
		 *        /
		 *      223           
		 */
       
             obj.root = new Node(1);
		 obj.root.left = new Node(2);
		 obj.root.right = new Node(3);
		 obj.root.left.left = new Node(7);
		 obj.root.left.right = new Node(6);
		 obj.root.right.left = new Node(5);
		 obj.root.right.right = new Node(4);
		 obj.root.left.left.left = new Node(8);
		 obj.root.left.left.right = new Node(9);
		 obj.root.right.right.right = new Node(23);
		 obj.root.left.left.left.left = new Node(223);
		 
		 //Travese obj
		 obj.levelordertraversal(obj.root); 
    }
    
    public void levelordertraversal(Node node){
        if(node == null) return;
         
        Queue<Node> q = new LinkedList();
        q.offer(node);
        while(q.size()>0){
            Node temp = q.poll();
            System.out.print(" "+temp.key);
            if(temp.left!=null) q.offer(temp.left);
            if(temp.right!=null) q.offer(temp.right);
        }
        
    }
    
}