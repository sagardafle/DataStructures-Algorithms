/**
 * A priority queue is different from a "normal" queue, because instead of being a "first-in-first-out" data structure, values come out in order by priority. 
 * By default the Priority Queue works as min-Heap. 
 * To implement the max-Heap we need to change the way priority queue works internally by overriding the Comparator.
 * Time complexity for the methods offer & poll is O(log(n)) and for the peek() it is Constant time O(1).
 * The Iterator provided in method iterator() is not guaranteed to traverse the elements of the priority queue in any particular order.
 * */
 
 /**
  * To implement the max-Heap, we need to change the way priority queue works internally by overriding the Comparator.
  */ 
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueMaxHeap {

PriorityQueue<Integer> pq;

	public PriorityQueueMaxHeap() {
		pq = new PriorityQueue<Integer>(10, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2 - o1;
			}
		});
	}
	
	/**
	 * 1. OFFER
	 */ 
	public void insert(int[] x) {
		for (int i = 0; i < x.length; i++) {
			pq.offer(x[i]);
		}
	}
	
	/**
	 * 2. Iterate
	 */
	 public void iterator(){
	 	Iterator it = pq.iterator();
		   System.out.println ( "Priority queue values are: ");
		   while (it.hasNext()){
		   System.out.println ( "Value: "+ it.next()); 
		    }
		  }
	 }
	

	/**
	 * 2. POLL (Not that after perfoming the extractmax operation, te heap goes through heapify process internally)
	 */ 
	public int extractMax() {
		return pq.poll();
	}


	/**
	 * 3. Size
	 */
	 
	public int getSize() {
		return pq.size();
	}


	
	/**
	 * 4. Peek 
	 */
	 public int peek(){
	 	return pq.peek();
	 }

	public static void main(String[] args) {
		int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };
		PriorityQueueMaxHeap i = new PriorityQueueMaxHeap();
		i.insert(arrA);
		System.out.println("Priority Queue: ");
		i.print();
	
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Priority Queue PEEK: " + i.peek());
		System.out.println("Priority Queue Size: " + i.getSize());
	
	}
}
