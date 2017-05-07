/**
 * Algorithm:
1. First add the ROOT to Stack.
2. Pop out an element from Stack and add its right and left children to stack.
3. Pop out an element and print it and add its children(right and left).
4. Repeat the above two steps until the Stack is empty.
*/

import java.util.*;
public class DFSTrees{
    Node root;
    
    public static void main(String args[]){
        DFSTrees obj = new DFSTrees();
        
         
        /**
		 * 
		 * 	       1 
		                / \
	* 		     2    3
	*                       / \  / \ 
	*                      7  6  5  4
	* 		  / \	   \
	*                    8  9        23
		 *        /
		 *      223           
		 */
       
                     obj.root = new Node(1);
		 obj.root.left = new Node(2);
		 obj.root.right = new Node(3);
		 obj.root.left.left = new Node(7);
		 obj.root.left.right = new Node(6);
		 obj.root.right.left = new Node(5);
		 obj.root.right.right = new Node(4);
		 obj.root.left.left.left = new Node(8);
		 obj.root.left.left.right = new Node(9);
		 obj.root.right.right.right = new Node(23);
		 obj.root.left.left.left.left = new Node(223);
		 
		 //Travese obj
		 obj.dfstraversal(obj.root); 
    }
    
    public void dfstraversal(Node node){
        Stack<Node> s = new Stack<Node>();
        s.push(node);
        while(!s.isEmpty()){
           Node temp = s.pop();
           System.out.print(temp.key+" ");
           if(temp.right!=null) s.push(temp.right);
           if(temp.left!=null) s.push(temp.left);
        }
    }
    
}