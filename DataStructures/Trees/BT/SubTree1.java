/**
 * Why we can't use in-order traversal ? 
 * SUppose that the given tree is a BST. In a BST, in-order traversal produces the output in a sorted way. 
 * So, it is definetly possible that we get the same inorder traversal for 2 diffrent BSTs with same values but diffrent structure.
          Logic1: 
          1. We use the preorder traversal.
          2. Whenever we encounter a null node, we add "X" as as identifier to indicate the end.
          3. We compare the preorder traversals of T1 and T2.  
 * */

public class SubTree1 {
    static Node root1,root2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String args[]){
        SubTree1 obj = new SubTree1();
        
        /**
		 * 
		 * 	             1
		 *                /         \
		 *               2             3                                   3
		 *            /    \         /   \                               /   \                        
		 *           7       6       5    4                            5      4
		 *          / \     / \     / \  /  \                         / \    /  \
		 *         8    9  X  X     X  X X  23                        X  X   X  23
		          / \  / \                  / \                                 / \
		         X  X  X  223               X  X                                X  X
		                  / \
		                  X  X
		                          T1                                        T2
		 /*Tree-1*/
		 obj.root1 = new Node(1);
		 obj.root1.left = new Node(2);
		 obj.root1.right = new Node(3);
		 obj.root1.left.left = new Node(7);
		 obj.root1.left.right = new Node(6);
		 obj.root1.right.left = new Node(5);
		 obj.root1.right.right = new Node(4);
		 obj.root1.left.left.left = new Node(8);
		 obj.root1.left.left.right = new Node(9);
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