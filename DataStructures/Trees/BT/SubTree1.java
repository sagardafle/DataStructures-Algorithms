/**
          Logic1: Using Preorder traversal.
          Logic2: Whenever we encounter the root of T2 in T1(larger tree), we check if the trees T2 and T1 are identical.
          
 * */

public class SubTree1 {
    static Node root1,root2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]){
        SubTree1 obj = new SubTree1();
        
        /**
		 * 
		 * 	       1                         
		                / \                       
	* 		     2    3                    3
	*                       / \  / \       == >       / \
	*                      7  6  5  4      == >       5  4
	* 		  / \	   \                    \ 
	*                    8  9        23                   23
		 *                                         
		 */
		 
		 /*Tree-1*/
		 obj.root1 = new Node(1);
		 obj.root1.left = new Node(2);
		 obj.root1.right = new Node(3);
		 obj.root1.left.left = new Node(7);
		 obj.root1.left.right = new Node(6);
		 obj.root1.right.left = new Node(5);
		 obj.root1.right.right = new Node(4);
		 obj.root1.left.left.left = new Node(9);
		 obj.root1.left.left.right = new Node(8);
		 obj.root1.right.right.right = new Node(23);
		 obj.root1.left.left.right.right = new Node(223);

		 /*Tree-2*/
		 obj.root2 = new Node(3);
		 obj.root2.left = new Node(5);
		 obj.root2.right = new Node(4);
		 obj.root2.right.right = new Node(23);
		 

		 //Check if T2 is subtree of T1
		 boolean isSubtree = obj.isSubTreeUsingPreOrder(obj.root1,obj.root2);
		 System.out.println("Is Subtree? " +isSubtree);
		 
    }
    
    boolean isSubTreeUsingPreOrder(Node root1,Node root2){
                  /* Empty tree is also a subtree*/
        	        if(root2 == null) return true;
        	        
        	        StringBuilder tree1path = preOrderTraversal(root1);
        	        sb = new StringBuilder(); //reset the stringbuilder object
        	        StringBuilder tree2path = preOrderTraversal(root2);
        	        System.out.println("tree1path "+tree1path);
        	        System.out.println("tree2path "+tree2path);
        	        return (tree1path.toString().indexOf(tree2path.toString()) != -1 ); // not equal to -1 means there was a match.
    }
    
    
          public StringBuilder preOrderTraversal(Node root) {
              if (root == null) {
                  sb.append("X ");
              } else {
                  sb.append(root.key + " ");
                  preOrderTraversal(root.left);
                  preOrderTraversal(root.right);
              }
              return sb;
          }
          
          
}