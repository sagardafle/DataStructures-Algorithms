/**
 * LOGIC: 
 * */
import java.util.*;
public class ValidBST{
    Node root;
    static boolean leftsubtree , rightsubtree;
    public static void main(String args[]){
        ValidBST obj = new ValidBST();
        
         
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
		 
		 //is valid BST?
		 System.out.println("Is Tree a BST? "+obj.isValidBSTRecursive(obj.root, Long.MIN_VALUE, Long.MAX_VALUE));
		 
		 //NEED TO WORK ON THIS
		// System.out.println("Is Tree a BST? "+obj.isValidBSTInOrder(obj.root));
    }
    
    public boolean isValidBSTRecursive(Node root,long min, long max){
         /* Empty tree is a valid BST */
         if(root == null) return true;
         
         return  (root.key > min && 
                  root.key < max && 
                  isValidBSTRecursive(root.left, min, root.key) && //SET THE NEW MIN AND MAX ACCORDINGLY
                  isValidBSTRecursive(root.right, root.key, max)
                 );
    }
}