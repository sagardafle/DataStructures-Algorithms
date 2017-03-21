public class SearchElement {
    Node root;
    
    public static void main(String args[]){
        SearchElement searchobj = new SearchElement();
        
        /**
		 * 
		 * 		     1 
		                / \
	* 			   2    3
	*                   / \  / \ 
	*                  7  6  5  4
	* 			/ \	     \
	*                8   9         23
		 *        /
		 *       223           
		 */
		 
		 searchobj.root = new Node(16);
		 searchobj.root.left = new Node(12);
		 searchobj.root.right = new Node(20);
		 searchobj.root.left.left = new Node(7);
		 searchobj.root.left.right = new Node(14);
		 searchobj.root.right.left = new Node(19);
		 searchobj.root.right.right = new Node(23);
		 searchobj.root.left.left.left = new Node(3);
		 searchobj.root.left.left.right = new Node(9);
		 searchobj.root.right.right.right = new Node(30);
		 searchobj.root.left.left.left.left = new Node(2);
		 
		 //Find max
		 boolean isPresent = searchobj.findsearchobj(searchobj.root, searchobj.root.left.left.left.key); //8
		 if(isPresent) System.out.println(searchobj.root.left.left.left.key+" is present"); 
		 else System.out.println(searchobj.root.left.left.left.key+" is absent"); 
		 
    }
    
    boolean findsearchobj(Node node, int target){ 
        if(node == null) return false;
        if(node.key == target) return true;
        return (findsearchobj(node.left, target) || findsearchobj(node.right, target));
        }
}