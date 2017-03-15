/**
 * Since the given tree is a binary tree, we can insert the element wherever we want. 
 * The only property of binary tree is that every node can have a maximum of two children. 
 * So, to keep the tree leveled we can perform a level order traversal on the binary tree 
 * and insert the element wherever we find the node whose right child or left child is NULL.
 * */
 import java.util.*;
public class InsertElement {
    Node root;
    
    public static void main(String args[]){
        InsertElement insertobj = new InsertElement();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                  7  6  5  4
	* 			/ \	     \
	*                8  9        23
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
		 insertobj.findpreOrder(insertobj.root);
		 System.out.println();
		 Node newtree =  insertobj.insertelement(insertobj.root, 300); //will be added to left of 6
		 insertobj.findpreOrder(newtree);
		 
		 
    }
    
    Node insertelement(Node node, int target){ 
        if(node == null) return null;
        Queue<Node> q = new LinkedList<Node>();
        q.offer(node);
         Node temp = null;
        while(q.size()>0){
           temp = q.poll();
           if(temp!=null){
               if(temp.left!=null) {
                  q.offer(temp.left);
            } else {
                 temp.left = new Node(target);
                 return node;
            }
            
            if(temp.right!=null){
                  q.offer(temp.right);
            } else {
                  temp.right = new Node(target);
                  return node;
            }  
           }
        }
        return node;
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