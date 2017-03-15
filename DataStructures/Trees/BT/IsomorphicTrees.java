public class IsomorphicTrees {
    static Node root1,root2;
    
    public static void main(String args[]){
        IsomorphicTrees mirrorobj = new IsomorphicTrees();
        
        /**
		 * 
		 * 		     1                         1
		                / \                       /  \
	* 			   2    3                    3    2
	*                   / \  / \       == >       / \  / \
	*                  7  6  5  4      == >      4   5 6  7
	* 		      / \	     \              /        / \ 
	*                8  9        23            23       9   8
		 *        /                                        \
		 *       223                                       223
		 */
		 
		 /*Tree-1*/
		 mirrorobj.root1 = new Node(1);
		 mirrorobj.root1.left = new Node(2);
		 mirrorobj.root1.right = new Node(3);
		 mirrorobj.root1.left.left = new Node(7);
		 mirrorobj.root1.left.right = new Node(6);
		 mirrorobj.root1.right.left = new Node(5);
		 mirrorobj.root1.right.right = new Node(4);
		 mirrorobj.root1.left.left.left = new Node(9);
		 mirrorobj.root1.left.left.right = new Node(8);
		 mirrorobj.root1.right.right.right = new Node(23);
		 mirrorobj.root1.left.left.right.right = new Node(223);

		 /*Tree-2*/
		 mirrorobj.root2 = new Node(1);
		 mirrorobj.root2.left = new Node(3);
		 mirrorobj.root2.right = new Node(2);
		 mirrorobj.root2.left.left = new Node(4);
		 mirrorobj.root2.left.right = new Node(5);
		 mirrorobj.root2.right.left = new Node(6);
		 mirrorobj.root2.right.right = new Node(7);
		 mirrorobj.root2.left.left.left = new Node(8);
		 mirrorobj.root2.left.left.right = new Node(9);
		 mirrorobj.root2.right.right.right = new Node(23);
		 mirrorobj.root2.left.left.left.left = new Node(223);
		 
		
		 
		 //Check if mirror
		 boolean isMirrorImage = mirrorobj.isIsomorphic(mirrorobj.root1,mirrorobj.root2);
		 System.out.println("Is Mirror image? " +isMirrorImage);
		 
    }
    
    boolean isIsomorphic(Node root1,Node root2){ 
        	/* base cases */
	       if(root1 == null && root2==null) return true;
	       if(root1 == null || root2== null) return false;
	       
	       if(root1.key != root2.key) return false;
	       
	       return (
	                  isIsomorphic(root1.left,root2.right) && 
	                  isIsomorphic(root1.right,root2.left)
	              );
            
    }
}