/**
 * 
 * 
 * What is a BALANCED Binary tree?
A tree where no leaf is much farther away from the root than any other leaf. 

An empty tree is height-balanced. A non-empty binary tree T is balanced if:
1) Left subtree of T is balanced
2) Right subtree of T is balanced
3) The difference between heights of left subtree and right subtree is not more than 1.
*/

/*
LOGIC: 
1. If the root is null, return TRUE. 
2. Calculate the height of the left subtree. 
3. Calculate the height of the right subtree. 
4. If the absolute diffrence between the 2 & 3 is less than and equal to 1 return TRUE.
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
            return -1;

        /* If tree is not empty then height = 1 + max of left height and right heights */
        return 1 + Math.max(height(node.left), height(node.right));
    }
}