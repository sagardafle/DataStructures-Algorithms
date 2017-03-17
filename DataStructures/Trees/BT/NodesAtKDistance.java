/**
 * 1. If root is Null, return 
 * 2. If K == 0, print root. 
 * 3. Recursively call the left and right subtree while decrementing the value of K.
 */ 
public class NodesAtKDistance {
    Node root;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String args[]){
        NodesAtKDistance kobj = new NodesAtKDistance();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                  7  6  5  4
	* 		      / \	     \
	*                8   9        23
		 *        /
		 *       223           
		 */
		 
		 kobj.root = new Node(1);
		 kobj.root.left = new Node(2);
		 kobj.root.right = new Node(3);
		 kobj.root.left.left = new Node(711);
		 kobj.root.left.right = new Node(6);
		 kobj.root.right.left = new Node(5);
		 kobj.root.right.right = new Node(4);
		 kobj.root.left.left.left = new Node(8);
		 kobj.root.left.left.right = new Node(9);
		 kobj.root.right.right.right = new Node(23);
		 kobj.root.left.left.left.left = new Node(223);
		 
		 kobj.findkobj(kobj.root, 3); 
		 
    }
    
    void findkobj(Node node, int k){ // 8 9 23
        if(node == null) return ;
        if(k == 0) {
              System.out.print(node.key+" ");
        }
        if(node.left!=null) findkobj(node.left,k-1);
        if(node.right!=null)findkobj(node.right,k-1);
    } 
}