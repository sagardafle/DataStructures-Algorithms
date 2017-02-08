class PostOrderRecursive{
    Node root;
    
    public static void main(String args[]){
        PostOrderRecursive postOrder = new PostOrderRecursive();
        
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
		 
		 postOrder.root = new Node(1);
		 postOrder.root.left = new Node(2);
		 postOrder.root.right = new Node(3);
		 postOrder.root.left.left = new Node(7);
		 postOrder.root.left.right = new Node(6);
		 postOrder.root.right.left = new Node(5);
		 postOrder.root.right.right = new Node(4);
		 postOrder.root.left.left.left = new Node(8);
		 postOrder.root.left.left.right = new Node(9);
		 postOrder.root.right.right.right = new Node(23);
		 postOrder.root.left.left.left.left = new Node(223);
		 
		 //Travese postOrder
		 postOrder.findpostOrder(postOrder.root); //23
    }
    
    void findpostOrder(Node node){
        if (node == null) return ;
        
        /*Traverse left subtree*/
        findpostOrder(node.left);
        
        /*Then traverse the right sub-tree*/
        findpostOrder(node.right);
        
        /*Finally print the ROOT*/
        System.out.print(" "+node.key);
        
    }
}