public class GenerateMirrors {
    static Node root;
    
    public static void main(String args[]){
        GenerateMirrors mirrorobj = new GenerateMirrors();
        
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
		 
		 mirrorobj.root = new Node(1);
		 mirrorobj.root.left = new Node(2);
		 mirrorobj.root.right = new Node(3);
		 mirrorobj.root.left.left = new Node(7);
		 mirrorobj.root.left.right = new Node(6);
		 mirrorobj.root.right.left = new Node(5);
		 mirrorobj.root.right.right = new Node(4);
		 mirrorobj.root.left.left.left = new Node(8);
		 mirrorobj.root.left.left.right = new Node(9);
		 mirrorobj.root.right.right.right = new Node(23);
		 mirrorobj.root.left.left.left.left = new Node(223);
		 
		 mirrorobj.preordertraversal(root);
		 System.out.println();
		 //Generate mirror
		 Node mirrortree = mirrorobj.generatemirrortree(mirrorobj.root);
		 mirrorobj.preordertraversal(mirrortree);
		 
    }
    
    Node generatemirrortree(Node node){ 
        	/* base cases */
	       if(node == null) return node;
	       
	       generatemirrortree(node.left);
	       generatemirrortree(node.right);
	       
	       /*Swap the left and right childrens*/
	       Node temp = node.left;
	       node.left = node.right;
	       node.right = temp;
	       
	       return node;
	        
    }
    
    public void preordertraversal(Node root){
          if(root!=null){
                System.out.print(root.key+" -> ");
                preordertraversal(root.left);
                preordertraversal(root.right);
          }
    }
}