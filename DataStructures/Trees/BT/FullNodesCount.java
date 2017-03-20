public class FullNodesCount {
    static Node root;
    
    public static void main(String args[]){
        FullNodesCount countobj = new FullNodesCount();
        
        /**
		 * 
		 * 	       1                         1
		                / \                       /  \
	* 		    2    3                    3    2
	*                      / \  / \       == >       / \  / \
	*                     7  6  5  4      == >      4   5 6  7
	* 		 / \	  \              /        / \ 
	*                   8  9        23            23       9   8
		 *        /                                        \
		 *       223                                       223
		 */

		 countobj.root = new Node(1);
		 countobj.root.left = new Node(2);
		 countobj.root.right = new Node(3);
		 countobj.root.left.left = new Node(7);
		 countobj.root.left.right = new Node(6);
		 countobj.root.right.left = new Node(5);
		 countobj.root.right.right = new Node(4);
		 countobj.root.left.left.left = new Node(8);
		 countobj.root.left.left.right = new Node(9);
		 countobj.root.right.right.right = new Node(23);
		 countobj.root.left.left.left.left = new Node(223);
		 int finalcount  = countobj.countFullNodes2(countobj.root);
		 System.out.println("Count "+finalcount);
		
		 
    }
    
   
    int countFullNodes2(Node node){
          if(node==null)
              return 0;
              
          return countFullNodes2(node.left) + countFullNodes2(node.right) + (node.left!=null && node.right!=null ? 1 : 0);
    }
    
    
}