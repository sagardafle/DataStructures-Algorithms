
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
		 Value val = new Value();
		 obj.getFloorAndCeil(obj.root, val, 7);
		 System.out.println("Floor and Ceil is: "+val.floor+", "+val.ceil);
    }
    
    void getFloorAndCeil(Node root, Value value, int key){
    	if(root==null)
    		return;
    	
    	if(root.key==key){
    		value.floor=root.key;
    		value.ceil=root.key;
    	}
    	
    	
    	if(root.key<key){
    		value.floor= root.key;
    		getFloorAndCeil(root.right, value, key);
    	}
    	else {
    		value.ceil= root.key;
    		getFloorAndCeil(root.left, value, key);
    	}
    }
    
    static class Value{
	   int floor= -1;
	   int ceil= -1;
   }
}
