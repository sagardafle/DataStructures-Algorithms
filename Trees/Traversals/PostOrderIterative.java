
/**
 * LOGIC:
 * 
    1. Push root to first stack.
    2. Loop while first stack is not empty
   2.1 Pop a node from first stack and push it to second stack
   2.2 Push left and right children of the popped node to first stack
    3. Print contents of second stack

*/
import java.util.*;
class PostOrderIterative{
    Node root;
    
    public static void main(String args[]){
        PostOrderIterative postOrder = new PostOrderIterative();
        
        /**
		 * 
		 * 		   		 1 
		                / \
	* 				   2    3
	*                / \  / \ 
	*               7  6  5  4
	* 			   / \		  \
	*             8  9       23
		 *       /
		 *      223           
		 */
		 
		 postOrder.root = new Node(1);
		 postOrder.root.left = new Node(2);
		 postOrder.root.right = new Node(3);
		 postOrder.root.left.left = new Node(7);
		 postOrder.root.left.right = new Node(6);
		 postOrder.root.right.left = new Node(5);
		 postOrder.root.right.right = new Node(4);
		 postOrder.root.left.left.left = new Node(8);
		 postOrder.root.left.left.right = new Node(9);
		 postOrder.root.right.right.right = new Node(23);
		 postOrder.root.left.left.left.left = new Node(223);
		 
		 //Travese postOrder
		 postOrder.findpostOrder(postOrder.root); 
    }
    
    void findpostOrder(Node node){
      if(node == null) return;
      Stack<Node> s1 = new Stack();
      Stack<Node> s2 = new Stack();
      
      /*Add the root to s1*/
      s1.push(node);
      Node temp = null;
      while(s1.size()>0){
            /*Remove the node from s1 and push to s2*/
             temp = s1.pop();
             s2.push(temp);
             
             /*add the left and right child of temp to s1*/
             if(temp.left!=null) s1.push(temp.left);
             if(temp.right!=null) s1.push(temp.right);
      }
     while(s2.size()>0){
         System.out.print(" "+s2.pop().key);
     }
       
    }
}