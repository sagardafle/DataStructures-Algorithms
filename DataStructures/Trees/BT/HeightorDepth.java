import java.util.*;
public class HeightorDepth {
    Node root;
    int height = 0;
    
    public static void main(String args[]){
        HeightorDepth heightorDepthobj = new HeightorDepth();
        
        /**
		 * 
		 * 		   		 1 
		                / \
	* 				   2    3
	*                / \  / \ 
	*               7  6  5  4
	* 			   / \		  \
	*             8  9       23
		 *        /
		 *       223           
		 */
		 
		 heightorDepthobj.root = new Node(1);
		 heightorDepthobj.root.left = new Node(2);
		 heightorDepthobj.root.right = new Node(3);
		 heightorDepthobj.root.left.left = new Node(7);
		 heightorDepthobj.root.left.right = new Node(6);
		 heightorDepthobj.root.right.left = new Node(5);
		 heightorDepthobj.root.right.right = new Node(4);
		 heightorDepthobj.root.left.left.left = new Node(8);
		 heightorDepthobj.root.left.left.right = new Node(9);
		 heightorDepthobj.root.right.right.right = new Node(23);
		 heightorDepthobj.root.left.left.left.left = new Node(223);
		 
		 int treeHeightorDepth = heightorDepthobj.computeHeightorDepth(heightorDepthobj.root);
		 System.out.println(" HeightorDepth:" +treeHeightorDepth);
    }
    
    int computeHeightorDepth(Node node){ 
        if(node == null) return 0;
        
            /* compute the depth of each subtree */
            int lDepth = computeHeightorDepth(node.left);
            int rDepth = computeHeightorDepth(node.right);
  
            /* use the larger one */
            if (lDepth > rDepth)
                return (lDepth + 1);
             else
                return (rDepth + 1);
        
    }
}