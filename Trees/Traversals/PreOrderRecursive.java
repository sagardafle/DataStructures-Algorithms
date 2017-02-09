class PreOrderRecursive{
    Node root;
    
    public static void main(String args[]){
        PreOrderRecursive preOrder = new PreOrderRecursive();
        
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
		 
		 preOrder.root = new Node(1);
		 preOrder.root.left = new Node(2);
		 preOrder.root.right = new Node(3);
		 preOrder.root.left.left = new Node(7);
		 preOrder.root.left.right = new Node(6);
		 preOrder.root.right.left = new Node(5);
		 preOrder.root.right.right = new Node(4);
		 preOrder.root.left.left.left = new Node(8);
		 preOrder.root.left.left.right = new Node(9);
		 preOrder.root.right.right.right = new Node(23);
		 preOrder.root.left.left.left.left = new Node(223);
		 
		 //Travese preOrder
		 preOrder.findpreOrder(preOrder.root); //23
    }
    
    void findpreOrder(Node node){
        if (node == null) return ;
        
        /*first print the ROOT*/
        System.out.print(" "+node.key);
        
        /*Traverse left subtree*/
        findpreOrder(node.left);
        
        /*Then traverse the right sub-tree*/
        findpreOrder(node.right);
        
    }
}