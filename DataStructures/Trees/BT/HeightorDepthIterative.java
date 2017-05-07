/**
 * 1. Create a Queue.
 * 2. Push root and null. Null indicates end of a particular level.
 * 3. While q.size()> 0: 
 *    3.1 Pop from Queue. (temp) 
 *    3.2 If temp != null, we add the left and right child of temp to the queue.
 *        Else if temp == null, this means we are done with this particular level and 
 *                we are good to move ahead with next level. We INCREMENT height at this step. 
 *    
 */
import java.util.*;
public class HeightorDepthIterative {
    Node root;

    public static void main(String args[]) {
        HeightorDepthIterative obj = new HeightorDepthIterative();


        /**
		 * 
		 * 		          1 
		                    /  \
	* 			       2    3
	*                       / \  / \ 
	*                     7  6  5   4
	* 		         / \	   \
	*                   8  9        23
		 *          /
		 *        223           
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

    public int heightorDepthIterative(Node node) {
        if (root == null) return 0;

        Queue < Node > q1 = new LinkedList < Node > ();
        int height = -1;
        q1.add(root);
        q1.add(null); //null in the queue indicates the end of the level

        while (!q1.isEmpty()) {
            Node temp = q1.poll();
            if (temp != null) {
                if (temp.left != null)
                    q1.add(temp.left);
                if (temp.right != null)
                    q1.add(temp.right);
            } else {
                //indicates that a level ended and all nodes of next level are in the queue
                height++; //increasing the height at the end of each level
                
                if (q1.isEmpty())
                    break; //indicates the end of level order traversal
                q1.add(null); //adding null at the end of queue(which contains all node of next level) to indicate for further levels
            }

        }
        return height;
    }
}