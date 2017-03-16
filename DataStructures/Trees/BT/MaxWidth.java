/**
 *  
 */ 
 import java.util.*;
public class MaxWidth {
    Node root;
    static int maxVal = Integer.MIN_VALUE;
    public static void main(String args[]){
        MaxWidth widthobj = new MaxWidth();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                 711  6  5  4
	* 		      / \	     \
	*                8   9        23
		 *                  
		 */
		 
		 widthobj.root = new Node(1);
		 widthobj.root.left = new Node(2);
		 widthobj.root.right = new Node(3);
		 widthobj.root.left.left = new Node(711);
		 widthobj.root.left.right = new Node(6);
		 widthobj.root.right.left = new Node(5);
		 widthobj.root.right.right = new Node(4);
		 widthobj.root.left.left.left = new Node(8);
		 widthobj.root.left.left.right = new Node(9);
		 widthobj.root.right.right.right = new Node(23);

		 System.out.println("Max width of tree is: "+widthobj.computemaxwidth(widthobj.root)); 
		 
    }
    
    int computemaxwidth(Node node){
        if(node == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        q.offer(null);
        int width = 0;
        int maxwidth = Integer.MIN_VALUE;
        while(q.size()>0){
              Node temp = q.poll();
              if(temp!=null){
                    width +=1;
                     if(temp.left!=null) q.add(temp.left);
                     if(temp.right!=null) q.add(temp.right);
              } else {
                    if(q.isEmpty()){
                          break;  // we have processed all the nodes
                    } else {
                          //Current level is processed, move to next level
                          q.add(null); //adding null at the end of queue(which contains all node of next level) to indicate for further levels
                          if(width>maxwidth) maxwidth = width;
                          width = 0;
                    }
              }
        }
        return maxwidth;
    }
}