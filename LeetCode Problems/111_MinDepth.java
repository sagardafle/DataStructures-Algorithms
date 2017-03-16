/**
 * LOGIC: 
 * 1. Calculate the depth of left subtree
 * 2. Calculate the depth of right subtree. 
 * 3. If the left depth and right depth are non-zero, then find min of them and add 1 to get the result .
 *    Else, return 1+left+right,
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    int mindepth = 0;
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        
        if(left == 0 || right == 0) return 1+left+right;
        else return 1+ Math.min(left,right);
    }
}