/*
You are given a NxN boolean matrix, where matrix(i,j) will be one if 'i' is a parent of 'j' in a tree, otherwise, it is zero. 
Construct this tree.
https://www.careercup.com/question?id=5181088604356608

*/
import java.util.ArrayList;
import java.util.List;

public class TreeAsAMatrix {
    public static void main(String[] args) {
        boolean[][] adj = buildAdjacenyMatrix();
        TreeNode tree = buildTree(adj);
        printTree(tree);
    }

    private static boolean[][] buildAdjacenyMatrix() {
        boolean[][] matrix = new boolean[6][];
        //                           0      1      2      3      4      5
        matrix[0] = new boolean[] { false, true , true , true , true , true  };
        matrix[1] = new boolean[] { false, false, false, true, false, false };
        matrix[2] = new boolean[] { false, false, false, false, false, false };
        matrix[3] = new boolean[] { false, false, true, false, false, false };
        matrix[4] = new boolean[] { false, false, false, false, false, true };
        matrix[5] = new boolean[] { false, false, false, false, false, false };

        return matrix;
    }

    private static TreeNode buildTree(boolean[][] adj) {
        TreeNode[] nodes = new TreeNode[adj.length];
        boolean[] hasParent = new boolean[adj.length];
        for(int i=0; i < adj.length; i++) {
            for(int j=0; j < adj.length; j++) {
                if (adj[i][j]) {
                    if (nodes[i] == null)
                        nodes[i] = new TreeNode(i);
                    if (nodes[j] == null)
                        nodes[j] = new TreeNode(j);
                    nodes[i].children.add(nodes[j]);
                    hasParent[j] = true;
                }
            }
        }

        for(int i=0; i < hasParent.length; i++)
            if(nodes[i] != null && !hasParent[i])
                return nodes[i];

        return null;
    }

    private static void printTree(TreeNode root) {
        if(root == null)
            System.out.println("Tree is empty");
        else
            printNode(root, "");
    }

    private static void printNode(TreeNode node, String prefix) {
        System.out.println(prefix + " -> " + node.data);
        for(TreeNode child : node.children)
            printNode(child, prefix + "   ");
    }

    private static class TreeNode {
        int data;
        List<TreeNode> children = new ArrayList<TreeNode>();
        TreeNode(int data) {
            this.data = data;
        }
    }

}