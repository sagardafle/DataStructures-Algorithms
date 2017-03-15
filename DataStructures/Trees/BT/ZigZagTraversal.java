/**
 * LOGIC: 
 * 1. We maintain 2 stacks. 
 * 2. Nodes in one particular will be inserted in the two stacks consecutively. 
 * 3. The only diffrence will be in the order in which the nodes will be inserted. 
 **/

import java.util.*;
public class ZigZagTraversal {
	static Node root;

	public static void main(String[] args) {
		ZigZagTraversal zigZag = new ZigZagTraversal();

	 /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                  7  6  5  4
	* 		      / \	     \
	*                8  9        23
		 *        /
		 *       223           
		 */
		 
		 zigZag.root = new Node(1);
		 zigZag.root.left = new Node(2);
		 zigZag.root.right = new Node(3);
		 zigZag.root.left.left = new Node(7);
		 zigZag.root.left.right = new Node(6);
		 zigZag.root.right.left = new Node(5);
		 zigZag.root.right.right = new Node(4);
		 zigZag.root.left.left.left = new Node(8);
		 zigZag.root.left.left.right = new Node(9);
		 zigZag.root.right.right.right = new Node(23);
		 zigZag.root.left.left.left.left = new Node(223);
		 zigZag.traverseSpiral(zigZag.root);
	}
	
	public void traverseSpiral(Node root){
	      if (root == null) return;
	      Stack<Node> s1 = new Stack<>();
	      Stack<Node> s2 = new Stack<>();
	      
	      s1.push(root);
	      
	      while(s1.size()>0 || s2.size() > 0){
	            
	            while(s1.size()>0){
	                  Node curr = s1.pop();
	                  System.out.print(curr.key+" ");
	                  if(curr.right != null) s2.push(curr.right);
	                  if(curr.left != null) s2.push(curr.left);
	                  
	            }
	            
	            
	            while(s2.size()>0){
	                  Node curr = s2.pop();
	                  System.out.print(curr.key+" ");
	                  /*Notice the diffrent order of inserting nodes in S2.*/
	                  if(curr.left != null) s1.push(curr.left);
	                  if(curr.right != null) s1.push(curr.right);
	                 
	            }
	      }
	      
	}
}