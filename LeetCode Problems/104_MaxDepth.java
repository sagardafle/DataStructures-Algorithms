/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

public class Solution {
    public int maxDepth(TreeNode node) {
        if (node == null) return 0; //-1 for calculating height 
              return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
    }
}