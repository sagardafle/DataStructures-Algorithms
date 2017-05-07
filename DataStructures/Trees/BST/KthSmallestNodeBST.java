/**
 * LOGIC: Keep traversing in "in-order" way.
 *        Every time we visit a node, we increment the counter. 
 *        When counter == k, we return the node value.
 * */
import java.util.*;
public class KthSmallestNodeBST {
    Node root;
    static int k;
    public static void main(String args[]) {
        KthSmallestNodeBST obj = new KthSmallestNodeBST();


        /**
		 * 
		 * 	        16 
		                /    \
	* 		    12     20
	*                      / \    /  \ 
	*                     7  14  19  23
	* 		 / \	     \
	*                   3  9           30
		 *       /
		 *       2          
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
        k = 4;
        int kthsmallest = obj.getKthSmallestNode(obj.root, k);
        System.out.println("KthSmallest " + kthsmallest);

    }

    private static int number = 0;
    private static int count = 0;
    public static int getKthSmallestNode(Node root, int k) {
        count = 0;
        helper(root);
        return number;
    }

    public static void helper(Node n) {
        if (n.left != null) helper(n.left);
        count++;
        if (count == k) {
            number = n.key;
            return;
        }
        if (n.right != null) helper(n.right);
    }

}