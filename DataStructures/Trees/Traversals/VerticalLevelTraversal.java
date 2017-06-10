import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;


/**
		 * 
		 * 	                     1 
		                      /     \
	* 		                 2        3
	*                       / \     /   \ 
	*                      4   5   6     7
	* 		  	                    \    \ 
	*                                 8    9
		 */

class VerticalLevelTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);

        printVerticalOrder(root);
    }

    public static void printVerticalOrder(Node node) {
        Map < Integer, List < Node >> map = new TreeMap < > ();

        printVerticalOrder(node, map, 0);

        for (Map.Entry < Integer, List < Node >> entry: map.entrySet()) {
            List < Node > list = entry.getValue();

            for (Node treeNode: list) {
                System.out.print(treeNode.key + " ");
            }
            System.out.println();
        }
    }

    private static void printVerticalOrder(Node node, Map < Integer, List < Node >> map, int hd) {
        if (node == null) {
            return;
        }

        if (map.containsKey(hd)) { //entry for this HD already exists
            map.get(hd).add(node); // add the current node to against existing HD key
        } else {
            List < Node > list = new ArrayList < > ();
            list.add(node);
            map.put(hd, list);
        }

        if (node.left != null) {
            printVerticalOrder(node.left, map, hd - 1);
        }

        if (node.right != null) {
            printVerticalOrder(node.right, map, hd + 1);
        }
    }
}