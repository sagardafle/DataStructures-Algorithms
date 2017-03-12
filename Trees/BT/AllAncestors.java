public class AllAncestors {
    Node root;
    
    public static void main(String args[]){
        AllAncestors ancestors = new AllAncestors();
        
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
		 
		 ancestors.root = new Node(1);
		 ancestors.root.left = new Node(2);
		 ancestors.root.right = new Node(3);
		 ancestors.root.left.left = new Node(7);
		 ancestors.root.left.right = new Node(6);
		 ancestors.root.right.left = new Node(5);
		 ancestors.root.right.right = new Node(4);
		 ancestors.root.left.left.left = new Node(8);
		 ancestors.root.left.left.right = new Node(9);
		 ancestors.root.right.right.right = new Node(23);
		 ancestors.root.left.left.left.left = new Node(223);
		 
		 //Find all ancestors
		 ancestors.findAncestors(ancestors.root, ancestors.root.right.right.right); //23
		 
    }
    
    boolean findAncestors(Node node, Node target){ //23
        	
        	/* base cases */
	        if (node == null) {
	            return false;
	        }
	        
	        if (node.key == target.key) {
	            return true;
	        }
	        
	         /* If target is present in either left or right subtree of this node,
	         then print this node */
	        if (findAncestors(node.left, target)
	                || findAncestors(node.right, target)) {
	            System.out.print(node.key + " ");
	            return true;
	        }
	 
	        /* Else return false */
	        return false;
	        
    }
}