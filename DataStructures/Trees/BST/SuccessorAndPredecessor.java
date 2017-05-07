public class SuccessorAndPredecessor {
    Node root;

    public static void main(String args[]) {
        SuccessorAndPredecessor obj = new SuccessorAndPredecessor();

        /**
		 * 
		 * 	        16 
		                /    \
	* 		     12     20
	*                       / \    /  \ 
	*                      7  14  19   23
	* 	            / \	    /  \
	*                    3  9        22   30
		 *        /
		 *       2          
		 */



        obj.root = new Node(16);
        obj.root.left = new Node(12);
        obj.root.right = new Node(20);
        obj.root.left.left = new Node(7);
        obj.root.left.right = new Node(14);
        obj.root.right.left = new Node(19);
        obj.root.right.right = new Node(23);
        obj.root.right.right.left = new Node(22);
        obj.root.left.left.left = new Node(3);
        obj.root.left.left.right = new Node(9);
        obj.root.right.right.right = new Node(30);
        obj.root.left.left.left.left = new Node(2);

        //Find InOrder Successor
        Node successor = obj.successor(obj.root, obj.root.left.right); //14
        System.out.println("The successor is: " + successor.key);

        //Find InOrder Predecessor
        Node predecessor = obj.predecessor(obj.root, obj.root.left.right); //14
        System.out.println("The predecessor is: " + predecessor.key);


    }

    /* Successor */

    public Node successor(Node root, Node p) {
        if (root == null)
            return null;

        if (root.key <= p.key) {
            return successor(root.right, p);
        } else {
            Node left = successor(root.left, p);
            return (left != null) ? left : root;
        }
    }


    /* Predecessor */

    public Node predecessor(Node root, Node p) {
        if (root == null)
            return null;

        if (root.key >= p.key) {
            return predecessor(root.left, p);
        } else {
            Node right = predecessor(root.right, p);
            return (right != null) ? right : root;
        }
    }
}