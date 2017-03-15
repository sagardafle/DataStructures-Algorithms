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
    public List<String> binaryTreePaths(TreeNode root) {
       List<String> pathList = new ArrayList<String>();
       if(root == null) return pathList;
       return binaryTreePathsHelper(root, "", pathList);
    }
    
    public List<String> binaryTreePathsHelper(TreeNode root, String path, List<String> pathList){
        if(root.left == null && root.right == null) {
            pathList.add(path+root.val);
            return pathList;
        }
        if(root.left!=null) binaryTreePathsHelper(root.left, path + root.val + "->", pathList);
        if(root.right!=null) binaryTreePathsHelper(root.right, path + root.val + "->", pathList);
        return pathList;
    }
}