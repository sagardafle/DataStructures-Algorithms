/**
 * A priority queue is an abstract data type where each element has a “priority” assigned to it.
 * So the element with the higher priority is served before the other elements.
 * By default the Priority Queue works as min-Heap.
 * */

import java.util.PriorityQueue;
public class PriorityQueueMinHeap {
    PriorityQueue<Integer> pq;
    
    public PriorityQueueMinHeap(){
        pq = new PriorityQueue<Integer>();
    }
    
    public void insert(int[] x) {
		for (int i = 0; i < x.length; i++) {
			pq.offer(x[i]);
		}
	}
	
	public int peek() {
		return pq.peek();
	}
	
	public int extractMin() {
		return pq.poll();
	}

	public int getSize() {
		return pq.size();
	}

	public void print() {
		System.out.println(pq);
	}
	public static void main(String[] args) {
		int[] arrA = { 1, 6, 2, 9, 4, 3, 8 };
		PriorityQueueMinHeap i = new PriorityQueueMinHeap();
		i.insert(arrA);
		i.print();
		System.out.println("Min Element in the Priority Queue: "
				+ i.extractMin());
		System.out.println("Min Element in the Priority Queue: "
				+ i.extractMin());
		System.out.println("Min Element in the Priority Queue: "
				+ i.extractMin());
		System.out.println("Priority Queue Size: " + i.getSize());
	}

}