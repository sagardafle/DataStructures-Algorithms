/**
 * LOGIC: 
 * */
import java.util.*;
public class FindMaxandMin{
    Node root;
    
    public static void main(String args[]){
        FindMaxandMin obj = new FindMaxandMin();
        
         
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
		 
		 //Max Element
		 System.out.println("Max Element "+obj.findMax(obj.root).key); //30
		 
		 //Min Element
		 System.out.println("Min Element "+obj.findMin(obj.root).key); //2
		 
    }
    
    public Node findMax(Node root){
          if (root == null || root.right==null) return root;
          else return findMax(root.right);
    }
    
    public Node findMin(Node root){
          if(root == null || root.left ==null) return root;
          else return findMin(root.left);
    }
    
  
}