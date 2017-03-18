
/**
 * LOGIC: 
 * */
import java.util.*;
public class CeilAndFloor{
    Node root;
    static int ceil , floor;
    public static void main(String args[]){
        CeilAndFloor obj = new CeilAndFloor();
        
         
        /**
		 * 
		 * 	                   16 
		                     /    \
	* 		               12     20
	*                      / \    /  \ 
	*                     7  14  19  23
	* 		             / \	        \
	*                   3  9            30
		 *             /
		 *            2          
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
		 
		 //get floor and ceil
		 obj.getFloorAndCeil(obj.root, 27);
		 System.out.println("Floor and Ceil is: "+floor+" ,"+ceil);
    }
    
    public void getFloorAndCeil(Node root, int k){
              if(root== null) return;
              
              if(root.key == k) ceil = floor = root.key;
              
              if(root.key<k) {
                        floor=root.key;
                        getFloorAndCeil(root.right,k);
              }
              
              if(root.key>k) {
                        ceil = root.key;
                        getFloorAndCeil(root.left,k);
              }
    }
    
}
