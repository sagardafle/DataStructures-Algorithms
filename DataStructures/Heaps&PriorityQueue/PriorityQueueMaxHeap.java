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
	
	public void insert(int[] x) {
		for (int i = 0; i < x.length; i++) {
			pq.offer(x[i]);
		}
	}

	public int extractMax() {
		return pq.poll();
	}

	public void display() {
		System.out.println(pq);
	}

	public int getSize() {
		return pq.size();
	}

	public void print() {
		System.out.println(pq);
	}

	public static void main(String[] args) {
		int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };
		PriorityQueueMaxHeap i = new PriorityQueueMaxHeap();
		i.insert(arrA);
		i.print();
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Max Element in the Priority Queue: "
				+ i.extractMax());
		System.out.println("Priority Queue Size: " + i.getSize());
	}
}
