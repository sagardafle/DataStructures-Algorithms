
/**
 * 
 * 
1) Create an empty stack nodeStack and push root node to stack.
2) Do following while nodeStack is not empty.
    a) Pop an item from stack and print it.
    b) Push right child of popped item to stack
    c) Push left child of popped item to stack

*/
import java.util.*;
class PreOrderIterative{
    Node root;
    
    public static void main(String args[]){
        PreOrderIterative preOrder = new PreOrderIterative();
        
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
		 
		 preOrder.root = new Node(1);
		 preOrder.root.left = new Node(2);
		 preOrder.root.right = new Node(3);
		 preOrder.root.left.left = new Node(7);
		 preOrder.root.left.right = new Node(6);
		 preOrder.root.right.left = new Node(5);
		 preOrder.root.right.right = new Node(4);
		 preOrder.root.left.left.left = new Node(8);
		 preOrder.root.left.left.right = new Node(9);
		 preOrder.root.right.right.right = new Node(23);
		 preOrder.root.left.left.left.left = new Node(223);
		 
		 //Travese preOrder
		 preOrder.findpreOrder(preOrder.root); 
    }
    
    void findpreOrder(Node node){
      if(node == null) return;
      Stack<Node> s = new Stack();
      s.push(node);
      while(s.size()>0){
          node = s.pop();
          System.out.print(" "+node.key);
          if(node.right!=null){
              s.push(node.right);
          }
          if(node.left!=null){
              s.push(node.left);
          }
      }
       
    }
}