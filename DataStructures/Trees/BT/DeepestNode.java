/**
 * 1. Calculate the height of tree first. 
 * 2. Traverse through tree recursively.
 * 3. When both left & right child of the nodes are null: 
 *    a. Check if (level+1 == height). If yes, then we have reach the leaf node. Print the data. 
 *    b. Continue traversing the left and right subtree. 
 */ 
public class DeepestNode {
    static Node root;
    
    public static void main(String args[]){
        DeepestNode deepestobj = new DeepestNode();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                   7  6  5  4
	* 			/ \	      \
	*                8  9         23
		 *        /            /
		 *       223         300 
		 *                  /
		 *                400
		 */
		 
		 deepestobj.root = new Node(1);
		 deepestobj.root.left = new Node(2);
		 deepestobj.root.right = new Node(3);
		 deepestobj.root.left.left = new Node(7);
		 deepestobj.root.left.right = new Node(6);
		 deepestobj.root.right.left = new Node(5);
		 deepestobj.root.right.right = new Node(4);
		 deepestobj.root.left.left.left = new Node(8);
		 deepestobj.root.left.left.right = new Node(9);
		 deepestobj.root.right.right.right = new Node(23);
		 deepestobj.root.right.right.right.left = new Node(300);
		 deepestobj.root.right.right.right.left.left = new Node(400);
		 deepestobj.root.left.left.left.left = new Node(223);
		 
		 int height = deepestobj.findHeight(deepestobj.root);
		 System.out.println("Height "+ height);
         
         deepestobj.deepestNode(deepestobj.root, height, 0);
		 
    }
    
    public void deepestNode(Node root, int height, int level){
        if(root == null) return ;
        if(root.left== null && root.right == null){
              System.out.println("Level "+level);
            if(level == height){
                  // This means we have reached the last level which will have the deepest node.
                System.out.println(root.key);
            }
        }
        /*Increment the level and call the children nodes*/
        deepestNode(root.left,height, 1+level);
        deepestNode(root.right,height, 1+level);
    }
    
        public int findHeight(Node root){
            if(root == null) return -1;
            return 1 + Math.max(findHeight(root.left), findHeight(root.right));
        }
}