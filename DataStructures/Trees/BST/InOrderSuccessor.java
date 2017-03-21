public class InOrderSuccessor {
    Node root;
    
    public static void main(String args[]){
        InOrderSuccessor successorobj = new InOrderSuccessor();
        
                /**
		 * 
		 * 	        16 
		                /    \
	* 		     12     20
	*                       / \    /  \ 
	*                      7  14  19   23
	* 	            / \	    /  \
	*                    3  9        22   30
		 *        /
		 *       2          
		 */


		 
		 successorobj.root = new Node(16);
		 successorobj.root.left = new Node(12);
		 successorobj.root.right = new Node(20);
		 successorobj.root.left.left = new Node(7);
		 successorobj.root.left.right = new Node(14);
		 successorobj.root.right.left = new Node(19);
		 successorobj.root.right.right = new Node(23);
		 successorobj.root.right.right.left = new Node(22);
		 successorobj.root.left.left.left = new Node(3);
		 successorobj.root.left.left.right = new Node(9);
		 successorobj.root.right.right.right = new Node(30);
		 successorobj.root.left.left.left.left = new Node(2);
		 
		 //Find InOrder Successor
		 Node successor = successorobj.findInOrderSuccessor(successorobj.root, successorobj.root.right.right.left); //22
		 System.out.println(successor.key);
		 
		 
    }
    
   public Node findInOrderSuccessor(Node root, Node p) {
              if(root==null)
                  return null;
           
              Node next = null;
              Node c = root;
              while(c!=null && c.key!=p.key){
                  if(c.key > p.key){
                      next = c;
                      c = c.left;
                  }else{
                      c= c.right;
                  }
              }
           
              if(c==null)        
                  return null;
           
              if(c.right==null)
                  return next;
           
              c = c.right;
              while(c.left!=null)
                  c = c.left;
           
              return c;
          }
}