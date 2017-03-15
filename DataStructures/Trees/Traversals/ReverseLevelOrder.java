/***
 *
 */ 
import java.util.*;
public class ReverseLevelOrder{
    Node root;
    
    public static void main(String args[]){
        ReverseLevelOrder obj = new ReverseLevelOrder();
        
         
        /**
		 * 
		 * 		     1 
		                / \
	* 		        2    3
	*                  / \  / \ 
	*                 7  6  5  4
	* 		     / \	    \
	*               8  9       23
		 *       /
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
		 obj.reverselevelordertraversal(obj.root); 
    }
    
    public void reverselevelordertraversal(Node node){
        if(node == null) return;
         
        Queue<Node> q = new LinkedList();
        Stack<Node> s = new Stack();
        q.offer(node);
        while(q.size()>0){
            Node temp = q.poll();
            if(temp.right!=null) q.offer(temp.right); //Push right child in queue first to get reverse order.
            if(temp.left!=null) q.offer(temp.left);
            s.push(temp);
        }
         while(s.size()>0){
         System.out.print(" "+s.pop().key);
        }
    }   
}