/**
 *  LOGIC : 
 * 1. This is a bottom-up approach. 
 * 2. If any of the target is found, it will be returned to its parents (in the form of 'left' or 'right' child).
 * 3. Parent will check if it was able to get both the childrens(left and right) , if yes, the parent is the LCA.
 * 4. If parent was not able to get any of the target nodes, it will return NULL else it will return the NON NULL node.
 */ 

public class LCA {
    Node root;
    public static void main(String args[]){
        LCA lcaobj = new LCA();
        
        /**
		 * 
		 * 		      1 
		                /   \
	* 			   2     3
	*                   / \   / \ 
	*                 711  6  5  4
	* 		      / \	     \
	*                8   9        23
		 *                  
		 */
		 
		 lcaobj.root = new Node(1);
		 lcaobj.root.left = new Node(2);
		 lcaobj.root.right = new Node(3);
		 lcaobj.root.left.left = new Node(711);
		 lcaobj.root.left.right = new Node(6);
		 lcaobj.root.right.left = new Node(5);
		 lcaobj.root.right.right = new Node(4);
		 lcaobj.root.left.left.left = new Node(8);
		 lcaobj.root.left.left.right = new Node(9);
		 lcaobj.root.right.right.right = new Node(23);

		 lcaobj.getLCA(lcaobj.root, lcaobj.root.right.left, lcaobj.root.right.right);  //5 & 4
		 
    }
    
    Node getLCA(Node root, Node A, Node B){ 
        
        /*Base Cases*/
        if(root == null) return null;
        if(root == A || root == B) return root;
        
        Node left = getLCA(root.left, A, B);
        Node right = getLCA(root.right, A, B);
        
        if(left == null) return right;
        if(right == null) return left;
        
        if(left!=null && right!=null) {
              System.out.println("THe LCA is: "+root.key);
              return root;
        }
        return null;
    }
}