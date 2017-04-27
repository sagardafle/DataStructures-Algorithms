
public class DiameterOfTree {
    static Node root;
    
    public static void main(String args[]){
        DiameterOfTree diameterobj = new DiameterOfTree();
        
        /**
		 * 
		 * 		                          1 
		                                 / \
	* 			                        2    3
	*                                  / \  / \ 
	*                                 7  6  5  4
	* 			                    / \         \
	*                              8  9         23
		 *                        /              /
		 *                      223            300 
		 *                     /
		 *                    400
		 */
		 
		 diameterobj.root = new Node(1);
		 diameterobj.root.left = new Node(2);
		 diameterobj.root.right = new Node(3);
		 diameterobj.root.left.left = new Node(7);
		 diameterobj.root.left.right = new Node(6);
		 diameterobj.root.right.left = new Node(5);
		 diameterobj.root.right.right = new Node(4);
		 diameterobj.root.left.left.left = new Node(8);
		 diameterobj.root.left.left.right = new Node(9);
		 diameterobj.root.right.right.right = new Node(23);
		 diameterobj.root.right.right.right.left = new Node(300);
		 diameterobj.root.right.right.right.left.left = new Node(400);
		 diameterobj.root.left.left.left.left = new Node(223);
		 
		 int diameter = diameterobj.findDiameter(diameterobj.root);
		 System.out.println("Diameter "+ diameter);
         
    }
    int max = 0;
    public int findDiameter(Node root){
            maxDepth(root);
            return max; //return left + right
    }
    
    public int maxDepth(Node root) {
                  if (root == null) return 0;
                  int left = maxDepth(root.left);
                  int right = maxDepth(root.right);
                  max = Math.max(max, left + right);
                  return 1 + Math.max(left, right); //return left + right + 1
          }
    }