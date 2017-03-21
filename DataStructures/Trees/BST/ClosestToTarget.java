/*Given a non-empty binary search tree and a target value, 
find the value in the BST that is closest to the target.*/

public class ClosestToTarget {
    Node root;
    static int goal;
    double min = Double.MAX_VALUE;
    public static void main(String args[]){
        ClosestToTarget closestobj = new ClosestToTarget();
        
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


		 
		 closestobj.root = new Node(16);
		 closestobj.root.left = new Node(12);
		 closestobj.root.right = new Node(20);
		 closestobj.root.left.left = new Node(7);
		 closestobj.root.left.right = new Node(14);
		 closestobj.root.right.left = new Node(19);
		 closestobj.root.right.right = new Node(23);
		 closestobj.root.right.right.left = new Node(22);
		 closestobj.root.left.left.left = new Node(3);
		 closestobj.root.left.left.right = new Node(9);
		 closestobj.root.right.right.right = new Node(30);
		 closestobj.root.left.left.left.left = new Node(2);
		 
		 
		  goal = closestobj.closestTarget(closestobj.root, 27); //22
		 System.out.println(goal);
		 
		 
    }
    
   public int closestTarget(Node root, double target) {
                helper(root, target);
                    return goal;
          }
          
          public void helper(Node root, double target){
                  if(root==null)
                      return;
           
                  if(Math.abs(root.key - target) < min){
                      min = Math.abs(root.key-target);
                      goal = root.key;
                  } 
           
                  if(target < root.key){
                      helper(root.left, target);
                  }else{
                      helper(root.right, target);
                  }
    }
}