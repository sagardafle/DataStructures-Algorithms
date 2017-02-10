import java.util.*;
public class InsertElement {
    Node root;
    
    public static void main(String args[]){
        InsertElement insertobj = new InsertElement();
        
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
		 
		 insertobj.root = new Node(1);
		 insertobj.root.left = new Node(2);
		 insertobj.root.right = new Node(3);
		 insertobj.root.left.left = new Node(7);
		 insertobj.root.left.right = new Node(6);
		 insertobj.root.right.left = new Node(5);
		 insertobj.root.right.right = new Node(4);
		 insertobj.root.left.left.left = new Node(8);
		 insertobj.root.left.left.right = new Node(9);
		 insertobj.root.right.right.right = new Node(23);
		 insertobj.root.left.left.left.left = new Node(223);
		 
		 insertobj.insertelement(insertobj.root, 300);
		 insertobj.findpreOrder(insertobj.root);
		 
    }
    
    void insertelement(Node node, int target){ 
        if(node == null) return ;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(node);
         Node temp = null;
        while(q.size()>0){
           temp = q.poll();
            if(temp.left!=null) q.offer(temp.left);
            if(temp.right!=null) q.offer(temp.right);
        }
        temp.left = new Node(target);
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