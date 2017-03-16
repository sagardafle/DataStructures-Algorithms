/**
 * 
 * 
A tree where no leaf is much farther away from the root than any other leaf. 

Consider a height-balancing scheme where following conditions should be checked to determine if a binary tree is balanced.
An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.


 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);

        if (Math.abs(left - right) <= 1 &&
            isBalanced(root.left) &&
            isBalanced(root.right))
            return true;
        else return false;
    }



    int height(TreeNode node) {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
}