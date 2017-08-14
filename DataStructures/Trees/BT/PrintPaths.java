import java.util.*;
public class PrintPaths {
    Node root;

    public static void main(String args[]){
        PrintPaths kobj = new PrintPaths();

        /**
		 * 
		 *               1 
		                / \
	* 		     2    3
	*                       / \  / \ 
	*                      7  6  5  4
	* 		  / \	   \
	*                    8   9        23
		 *        /
		 *       223           
		 */
		 
		 kobj.root = new Node(1);
		 kobj.root.left = new Node(2);
		 kobj.root.right = new Node(3);
		 kobj.root.left.left = new Node(7);
		 kobj.root.left.right = new Node(6);
		 kobj.root.right.left = new Node(5);
		 kobj.root.right.right = new Node(4);
		 kobj.root.left.left.left = new Node(8);
		 kobj.root.left.left.right = new Node(9);
		 kobj.root.right.right.right = new Node(23);
		 kobj.root.left.left.left.left = new Node(223);
		 
		 System.out.println(kobj.binaryTreePaths(kobj.root)); 
		 
    }
    
    public List<String> binaryTreePaths(Node root) {
       List<String> pathList = new ArrayList<String>();
       if(root == null) return pathList;
       return binaryTreePathsHelper(root, "", pathList);
    }
    
    public List<String> binaryTreePathsHelper(Node root, String path, List<String> pathList){
        if(root.left == null && root.right == null) { //we have reached the end.
            pathList.add(path+root.key);
            return pathList;
        }
        if(root.left!=null) binaryTreePathsHelper(root.left, path + root.key + "->", pathList);
        if(root.right!=null) binaryTreePathsHelper(root.right, path + root.key + "->", pathList);
        return pathList;
    }
}