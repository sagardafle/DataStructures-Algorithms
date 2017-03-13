class InOrderRecursive{
    Node root;
    
    public static void main(String args[]){
        InOrderRecursive inOrder = new InOrderRecursive();
        
        /**
		 * 
		 * 		   		 1 
		                / \
	* 				   2    3
	*                / \  / \ 
	*               7  6  5  4
	* 			   / \		  \
	*             8  9       23
		 *        /
		 *       223           
		 */
		 
		 inOrder.root = new Node(1);
		 inOrder.root.left = new Node(2);
		 inOrder.root.right = new Node(3);
		 inOrder.root.left.left = new Node(7);
		 inOrder.root.left.right = new Node(6);
		 inOrder.root.right.left = new Node(5);
		 inOrder.root.right.right = new Node(4);
		 inOrder.root.left.left.left = new Node(8);
		 inOrder.root.left.left.right = new Node(9);
		 inOrder.root.right.right.right = new Node(23);
		 inOrder.root.left.left.left.left = new Node(223);
		 
		 //Travese Inorder
		 inOrder.findinOrder(inOrder.root); //23
    }
    
    void findinOrder(Node node){
        if (node == null) return ;
        
        /*first traverse the left sub-tree*/
        findinOrder(node.left);
        
        /*print the data at root*/
        System.out.print(" "+node.key);
        
        /*Then traverse the right sub-tree*/
        findinOrder(node.right);
        
    }
}