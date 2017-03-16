/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBSTRecursive(TreeNode root,long min, long max){
        /* Empty tree is a valid BST */
         if(root == null) return true;
         
         return  (root.val > min && 
                  root.val < max && 
                  isValidBSTRecursive(root.left, min, root.val) &&
                  isValidBSTRecursive(root.right, root.val, max)
                 );
    }
}