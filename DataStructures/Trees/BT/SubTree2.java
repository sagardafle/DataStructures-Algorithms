/**
          Logic1: Using Preorder traversal.
          Logic2: Whenever we encounter the root of T2 in T1(larger tree), we check if the trees T2 and T1 are identical.
          
 * */

public class SubTree2 {
    static Node root1,root2;
    public static void main(String args[]){
        SubTree2 obj = new SubTree2();
        
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
		 
		 boolean isSubtree = obj.isSubTreeUsingIdenticalProperty(obj.root1,obj.root2);
		 
		 System.out.println("Is Subtree? " +isSubtree);
		 
    }
    
    boolean isSubTreeUsingIdenticalProperty(Node root1,Node root2){
                 if(root1==null) return false; //big tree cannot be empty.
                 
                 if((root1.key == root2.key) && areTreesIdentical(root1,root2)) return true;
                 
                 //we need to check for T2's root with every node of of root2.Hence we only change the childrens of root1 and not root2.
                 return isSubTreeUsingIdenticalProperty(root1.left,root2) || isSubTreeUsingIdenticalProperty(root1.right,root2);
    }
    
    
          public boolean areTreesIdentical(Node node1, Node root2) {
               if(root1 == null && root2 == null) return true;
               else if(root1 == null || root2 == null) return false;
               else if  (root1.key == root2.key) return true;
               else {
                       return root1.key == root2.key
                       && areTreesIdentical(root1.left,root2.left) 
                       && areTreesIdentical(root1.right,root2.right);
               }
          }
          
          
}