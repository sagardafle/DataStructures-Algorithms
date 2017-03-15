/**
 *  Subtract the node value from the sum before calling its children recursively.
 */ 
 import java.util.*;
public class HasPathSum {
    Node root;
    public static void main(String args[]){
        HasPathSum sumpathobj = new HasPathSum();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \   / \ 
	*                 711  6  5  4
	* 		      / \	     \
	*                8   9        23
		 *                  
		 */
		 
		 sumpathobj.root = new Node(1);
		 sumpathobj.root.left = new Node(2);
		 sumpathobj.root.right = new Node(3);
		 sumpathobj.root.left.left = new Node(711);
		 sumpathobj.root.left.right = new Node(6);
		 sumpathobj.root.right.left = new Node(5);
		 sumpathobj.root.right.right = new Node(4);
		 sumpathobj.root.left.left.left = new Node(8);
		 sumpathobj.root.left.left.right = new Node(9);
		 sumpathobj.root.right.right.right = new Node(23);

		 //Find max
		 System.out.println("Has sum path?: "+sumpathobj.hassumpath(sumpathobj.root , 31)); 
		 
    }
    
    boolean hassumpath(Node node , int sum){ 
        if(node == null) return false;
        
        /*Check if we have reached the sum and that this is the leaf node*/
        if(node.key == sum && node.left == null && node.right == null) return true;
        
        return (hassumpath(node.left, sum-node.key) || hassumpath (node.right, sum-node.key));
    }
}