/**
 * 1. Calculate the max element from the left subtree.
 * 2. Calculate the max element from the right subtree.
 * 3. Pick the max from 1&2. 
 * 4. Compare the max with rot. 
 */ 
public class MaxElement {
    Node root;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String args[]){
        MaxElement maxobj = new MaxElement();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                  7  6  5  4
	* 		      / \	     \
	*                8   9        23
		 *        /
		 *       223           
		 */
		 
		 maxobj.root = new Node(1);
		 maxobj.root.left = new Node(2);
		 maxobj.root.right = new Node(3);
		 maxobj.root.left.left = new Node(711);
		 maxobj.root.left.right = new Node(6);
		 maxobj.root.right.left = new Node(5);
		 maxobj.root.right.right = new Node(4);
		 maxobj.root.left.left.left = new Node(8);
		 maxobj.root.left.left.right = new Node(9);
		 maxobj.root.right.right.right = new Node(23);
		 maxobj.root.left.left.left.left = new Node(22);
		 
		 //Find max
		 System.out.println("Max value is: "+maxobj.findmaxobj(maxobj.root)); 
		 
    }
    
    int findmaxobj(Node node){ //711
        if(node.key > maxVal) {
              maxVal = node.key;
        }
        if(node.left!=null)  findmaxobj(node.left);
        if(node.right!=null) findmaxobj(node.right);
       
        return maxVal;
    }
}