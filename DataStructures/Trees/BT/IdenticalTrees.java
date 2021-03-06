import java.util.*;
public class IdenticalTrees {
    Node root1 ,root2;
    
    public static void main(String args[]){
        IdenticalTrees IdenticalTrees = new IdenticalTrees();
        
        /**
		 * 
		 * 		     1                               1
		                / \                            /   \
	* 			   2    3                         2     3
	*                   / \  / \                       / \    /\
	*                  7  6  5  4                    7   6   5  4
	* 		
		 */
		 
	      IdenticalTrees tree = new IdenticalTrees();
  
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
  
        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
  
        if (tree.identicalTrees(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");
    }
    
    /* Given two trees, return true if they are
       structurally identical */
    boolean identicalTrees(Node a, Node b) 
    {
        /*1. both empty */
        if (a == null && b == null)
            return true;
        /*2. either of them is empty */
             if(a == null || b ==null)
               return false;

            return ((a.key == b.key)
                    && identicalTrees(a.left, b.left)
                    && identicalTrees(a.right, b.right));
  
    }
}