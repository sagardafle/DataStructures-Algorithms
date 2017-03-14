/***
 *    Create a queue.
      Push root into the queue.
      height = 0
      Loop
	      nodeCount = size of queue
        
        // If number of nodes at this level is 0, return height
	if nodeCount is 0
		return Height;
	else
		increase Height

        // Remove nodes of this level and add nodes of 
        // next level
	while (nodeCount > 0)
		pop node from front
		push its children to queue
		decrease nodeCount
       // At this point, queue has nodes of next level
 */ 
import java.util.*;
public class HeightorDepthIterative{
    Node root;
    
    public static void main(String args[]){
        HeightorDepthIterative obj = new HeightorDepthIterative();
        
         
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                  / \  / \ 
	*                 7  6  5  4
	* 		     / \	    \
	*               8  9       23
		 *       /
		 *      223           
		 */
       
             obj.root = new Node(1);
		 obj.root.left = new Node(2);
		 obj.root.right = new Node(3);
		 obj.root.left.left = new Node(7);
		 obj.root.left.right = new Node(6);
		 obj.root.right.left = new Node(5);
		 obj.root.right.right = new Node(4);
		 obj.root.left.left.left = new Node(8);
		 obj.root.left.left.right = new Node(9);
		 obj.root.right.right.right = new Node(23);
		 obj.root.left.left.left.left = new Node(223);
		 
		 //Travese obj
		 System.out.print(obj.heightorDepthIterative(obj.root)); 
    }
    
    public int heightorDepthIterative(Node node){
        if(node == null) return 0;
        int height = -1; // cant set to 0, because height = 0 indicates root.
        
        Queue<Node> q = new LinkedList();
        q.offer(node);
        
        while(q.size()>0){
            int nodeCount = q.size();
            
            /*If number of nodes at this level is 0, return height*/
            if(nodeCount == 0) {
                  return height;
            } else {
                  height++;
            }
            
            /*Remove nodes of this level and add nodes of the next level*/
            while (nodeCount>0){
                  /*pop node from front*/
                  Node temp = q.poll();
                  
                  /*Decrease the node count*/
                  nodeCount--;
                  
                  /*push its children to queue*/
                  if(temp.left!=null) q.offer(temp.left);
                  if(temp.right!=null) q.offer(temp.right);
            }
        }
        return height;
    }
    
}