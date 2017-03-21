/**
 * LOGIC: 
 * A new key is always inserted at leaf. 
 * We start searching a key from root till we hit a leaf node. 
 * Once a leaf node is found, the new node is added as a child of the leaf node.
 * */
import java.util.*;
public class InsertandSearch{
    Node root;
    
    public static void main(String args[]){
        InsertandSearch obj = new InsertandSearch();
        
         
        /**
		 * 
		 * 		      16 
		                /    \
	* 		         12     20
	*                   / \    /  \ 
	*                  7  14  19  23
	* 			/ \	       \
	*                3  9          30
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
		 
		 
		 obj.preOrder(obj.root);
		 obj.insertElement(obj.root,34);
		 System.out.println();
		 obj.preOrder(obj.root);
    }
    

    
    public Node insertElement (Node root, int element){
          if(root == null){
               root =  new Node(element);
               return root;
          }
          
          if(root.key<element){
                root.right = insertElement(root.right, element);
          } else {
                root.left = insertElement(root.left, element);
          }
          
          return root;
    }
    
    public void preOrder(Node root){
          System.out.print(root.key+ " ");
          if(root.left!=null) preOrder(root.left);
          if(root.right!=null) preOrder(root.right);
    }
}