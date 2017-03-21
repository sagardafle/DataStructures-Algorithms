/**
 *  LOGIC : 
 * 1. This is a bottom-up approach. 
 * 2. If any of the target is found, it will be returned to its parents (in the form of 'left' or 'right' child).
 * 3. Parent will check if it was able to get both the childrens(left and right) , if yes, the parent is the LCA.
 * 4. If parent was not able to get any of the target nodes, it will return NULL else it will return the NON NULL node.
 */ 

public class LCAinBST {
    Node root;
    static Node left,right;
    public static void main(String args[]){
        LCAinBST obj = new LCAinBST();
        
             
        /**
		 * 
		 * 	        16 
		                /    \
	* 		    12     20
	*                      / \    /  \ 
	*                     7  14  19  23
	* 		 / \	     \
	*                   3  9           30
		 *       /
		 *      2          
		 */

		 
		 obj.root = new Node(16);
		 obj.root.left = new Node(12);
		 obj.root.right = new Node(20);
		 obj.root.left.left = new Node(7);
		 obj.root.left.right = new Node(14);
		 obj.root.right.left = new Node(19);
		 obj.root.right.right = new Node(23);
		 obj.root.left.left.left = new Node(3);
		 obj.root.left.left.right = new Node(9);
		 obj.root.right.right.right = new Node(30);
		 obj.root.left.left.left.left = new Node(2);

		 Node lca = obj.getLCA(obj.root, obj.root.left.right, obj.root.right.right);  //14 & 23
		 System.out.println("LCA "+lca.key);
		 
    }
    
    Node getLCA(Node root, Node n1, Node n2){ 
        
        /*Base Cases*/
        if(root == null) return null;
        if(root == n1 || root == n2) return root;
        
         /*If both n1 and n2 are smaller than root, then LCA lies in left*/
        if (root.key > n1.key && root.key > n2.key)
            return getLCA(root.left, n1, n2);
        
        /*If both n1 and n2 are greater than root, then LCA lies in right.*/
        if (root.key < n1.key && root.key < n2.key)
            return getLCA(root.right, n1, n2);
        
        /*If the nodes n1and n2 are on the left and right side of the root, the LCA is going to be the ROOT itself*/
        return root;
    }
}