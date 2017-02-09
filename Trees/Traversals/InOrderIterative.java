/**
 * 
1) Create an empty stack S.
2) Initialize current node as root
3) Push the current node to S and set current = current->left until current is NULL
4) If current is NULL and stack is not empty then 
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right 
     c) Go to step 3.
5) If current is NULL and stack is empty then we are done.
*/

import java.util.*;
class InOrderIterative{
    Node root;
    
    public static void main(String args[]){
        InOrderIterative inOrder = new InOrderIterative();
        
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
		 
		 inOrder.root = new Node(1);
		 inOrder.root.left = new Node(2);
		 inOrder.root.right = new Node(3);
		 inOrder.root.left.left = new Node(7);
		 inOrder.root.left.right = new Node(6);
		 inOrder.root.right.left = new Node(5);
		 inOrder.root.right.right = new Node(4);
		 inOrder.root.left.left.left = new Node(8);
		 inOrder.root.left.left.right = new Node(9);
		 inOrder.root.right.right.right = new Node(23);
		 inOrder.root.left.left.left.left = new Node(223);
		 
		 //Travese inOrder
		 inOrder.findinOrder(inOrder.root); 
    }
    
    void findinOrder(Node node){
       
       //keep the nodes in the path that are waiting to be visited
        Stack<Node> stack = new Stack<Node>();
       // Node node = root;
         
        //first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
         
        // traverse the tree
        while (stack.size() > 0) {
           
            // visit the top node
            node = stack.pop();
            System.out.print(node.key + " ");
            if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
       
    }
}