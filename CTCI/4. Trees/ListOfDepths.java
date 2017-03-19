 import java.util.*;
 
         /**
		 * 
		 * 	             16 
		                     /    \
	* 		          12     20
	*                             / \    / \ 
	*                           7  14   19  23
	* 		       / \	  \
	*                         3  9            30
		 *             /
		 *            2          
		 */

 
 public class ListOfDepths{
    Node root;
    public static void main(String[] args){
          ListOfDepths obj = new ListOfDepths();
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
		 
		  List<List<Integer>> requiredList = obj.printListOfDepths(obj.root);  
		  System.out.println(requiredList);
    }
    
 public List<List<Integer>> printListOfDepths(Node root) {
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        makeList(finalList,root,0);
        return finalList;
    }
    
    public static List<List<Integer>> makeList(List<List<Integer>> finalList, Node root, int level){
        
        if(root==null)
        return finalList;
        
        List<Integer> levelList=null;
        if(finalList.size()==level){
            levelList = new ArrayList<Integer>();
            finalList.add(levelList);
        }
        
        levelList = finalList.get(level);
        levelList.add(root.key);
        
        makeList(finalList, root.left, level+1);
        makeList(finalList, root.right, level+1);
        
        return finalList;
    }  
 }
 