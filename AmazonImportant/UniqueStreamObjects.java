import java.util.*;
public class UniqueStreamObjects{

	private static class Node{
		Object obj;
		Node prev;
		Node next;
		int id;
		public int getId(){
		          return id;
		}
		Node(Object ob){
			obj = ob;
		}
	}
	
	Map<Integer,Node> mp;
	Set<Integer> seen;
	Node head;
	Node tail;
	
	public UniqueStreamObjects(){
		mp = new HashMap<Integer,Node>();
		seen = new HashSet<Integer>();
	}
	
	public Object getUnique(){
		if(head == null){
			return null;
		}
		return head;
	}
	
	public void addObject(Object obj){
		int id = obj.getId();//could be hash code.
		if(mp.containsKey(id)){
			Node n = mp.get(id);
			mp.remove(id);
			removeNode(n);
			seen.add(id);
		}else{
			if(!seen.contains(id)){
				Node n = new Node(obj);
				mp.put(id,n);
				addNode(n);
			}
		}
	}
	
	private void addNode(Node n){
		if(head == null){
			head = n;
			tail = n;
		}else{
			tail.next = n;
			n.prev = tail;
			tail = tail.next;
		
		
		}
	}
	
	private void removeNode(Node x){
		if(head == x){
			Node tmp = head.next;
			if(tmp != null){
				tmp.prev = null;
				head.next = null;
				head = tmp;
			}else{
				head = null;
				tail = null;
			}
		}
		else if(tail == x){
			Node tmp = tail.prev;
			tmp.next = null;
			tail.prev = null;
			tail = tmp;
			
		}else{
			x.prev.next = x.next;
			x.next.prev = x.prev;
			x.prev = null;
			x.next = null;
			
		}
	
	}

}