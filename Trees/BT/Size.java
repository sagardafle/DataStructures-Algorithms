import java.util.*;
public class Size {
    Node root;
    
    public static void main(String args[]){
        Size sizeobj = new Size();
        
        /**
		 * 
		 * 		   		 1 
		                / \
	* 				   2    3
	*                / \  / \ 
	*               7  6  5  4
	* 			   / \		  \
	*             8  9       23
		 *        /
		 *       223           
		 */
		 
		 sizeobj.root = new Node(1);
		 sizeobj.root.left = new Node(2);
		 sizeobj.root.right = new Node(3);
		 sizeobj.root.left.left = new Node(7);
		 sizeobj.root.left.right = new Node(6);
		 sizeobj.root.right.left = new Node(5);
		 sizeobj.root.right.right = new Node(4);
		 sizeobj.root.left.left.left = new Node(8);
		 sizeobj.root.left.left.right = new Node(9);
		 sizeobj.root.right.right.right = new Node(23);
		 sizeobj.root.left.left.left.left = new Node(223);
		 
		 int treesize = sizeobj.computesize(sizeobj.root);
		 System.out.println(" Size:" +treesize);
		
		 
    }
    
    int computesize(Node node){ 
        if(node == null) return 0;
        int leftheight , rightheight;
        leftheight = rightheight =0;
        if(node.left!=null) {
             leftheight = computesize(node.left);
        }
        if(node.right!=null) {
             rightheight = computesize(node.right);
        }
        return 1 + leftheight + rightheight;
    }
    
  
}