import java.util.*;
public class DistinctCount {
    Node root;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String args[]) {
        DistinctCount kobj = new DistinctCount();

        /**
		 * 
		 * 		         1 
		                / \
	* 			       1    1
	*                / \  / \ 
	*               1  6  5  4
	* 		      / \	     \
	*                8   9        23
		 *        /
		 *       223           
		 */

        kobj.root = new Node(1);
        kobj.root.left = new Node(1);
        kobj.root.right = new Node(1);
        kobj.root.left.left = new Node(1);
        kobj.root.left.right = new Node(1);
        kobj.root.right.left = new Node(1);
        kobj.root.right.right = new Node(1);
        kobj.root.left.left.left = new Node(1);
        kobj.root.left.left.right = new Node(9);
        kobj.root.right.right.right = new Node(23);
        kobj.root.left.left.left.left = new Node(223);

        System.out.println("No of distinct elements:"+kobj.getDisCnt(kobj.root));
    }

    public static int getDisCnt(Node root) {
        Set < Integer > uniq = new HashSet < > ();
        if (root == null) {
            return uniq.size();
        }
        return getMaxHelper(root, uniq);
    }

    public static int getMaxHelper(Node root, Set < Integer > uniq) {
        if (root == null) {
            return uniq.size();
        }
        int l = 0;
        int r = 0;
        if (uniq.add(root.key)) {
            l = getMaxHelper(root.left, uniq);
            r = getMaxHelper(root.right, uniq);
            uniq.remove(uniq.size() - 1);
        } else {
            l = getMaxHelper(root.left, uniq);
            r = getMaxHelper(root.right, uniq);
        }
        return Math.max(l, r);
    }
}