/**
 * http://algorithms.tutorialhorizon.com/binary-min-max-heap/
 * A binary heap is a heap data structure created using a binary tree.
 
    2 Rules: 
 1. Binary Heap has to be complete binary tree at all levels except the last level. This is called shape property.
 2. All nodes are either greater than equal to (Max-Heap) or less than equal to (Min-Heap) to each of its child nodes. This is called heap property.
 
 
Implementation:

Use array to store the data.
Start storing from index 1, not 0.
For any given node at position i:
Its Left Child is at [2*i] if available.
Its Right Child is at [2*i+1] if available.
Its Parent Node is at [i/2]if available.

Heap Majorly has 3 operations -

Insert Operation
Delete Operation
Extract-Min (OR Extract-Max)

1. Insert Operation:

Add the element at the bottom leaf of the Heap.
Perform the Bubble-Up(SWIM) operation.
All Insert Operations must perform the bubble-up operation(it is also called as up-heap, percolate-up, sift-up, trickle-up, heapify-up, or cascade-up).

1.1 Bubble-up (SWIM) Operation:

If inserted element is larger than its parent node in case of Max-Heap OR smaller than its parent node in case of Min-Heap, swap the element with its parent.
Keep repeating the above step, if node reaches its correct position, STOP.

1.2 Sink-Down Operation:

If replaced element is greater than any of its child node in case of Min-Heap OR smaller than any if its child node in case of Max-Heap, swap the element with its smallest child(Min-Heap) or with its greatest child(Max-Heap).
Keep repeating the above step, if node reaches its correct position, STOP.

2. Delete Operation:

Find the index for the element to be deleted.
Take out the last element from the last level from the heap and replace the index with this element .
Perform Sink-Down.

3.Extract-Min OR Extract-Max Operation:

Take out the element from the root.( it will be minimum in case of Min-Heap and maximum in case of Max-Heap).
Take out the last element from the last level from the heap and replace the root with the element.
Perform Sink-Down
All delete operation must perform Sink-Down Operation ( also known as bubble-down, percolate-down, shift-down, trickle down, heapify-down, cascade-down).


Time and Space Complexity:

Space	O(n)
Search	O(n)
Insert	O(log n)
Delete	O(log n)
*/

public class BinaryMaxHeap{
    public int size;
	public int [] mH;
	public int position;
	
	public BinaryMaxHeap(int size){
		this.size=size;
		mH = new int [size+1];
		position = 0;
	}
	
	public void createHeap(int [] arrA){
		if(arrA.length>0){
			for(int i=0;i<arrA.length;i++){
				insert(arrA[i]);
			}
		}		
	}
	
	public void insert(int x){
	    if(position==0){
	        mH[position+1]=x;
			position = 2;
	    } else{
			mH[position++]=x;
			swim();
		}
	}
	
	/**
	 * balances the binary tree if the parent<children or children>parent.
	 */ 
	
	public void swim(){
	    int pos = position-1;
		while(pos>0 && mH[pos/2]<mH[pos]){  //swap only if parent<children
			int y = mH[pos];
			mH[pos]=mH[pos/2];
			mH[pos/2] = y;
			pos = pos/2; //set pos to parent and do the same check.
		}
	}
	
	
	public int extractMax(){
		int max = mH[1];
		mH[1]=mH[position-1];
		mH[position-1]=-1;
		position--;		
		sinkDown(1);
		return max;
	}
	
	public void sinkDown(int k){
		System.out.println("k =  " + k);
		int a = mH[k];
		int smallest = k;
		if(2*k<position && mH[smallest]<mH[2*k]){
			System.out.println("Setting smallest to  " + 2*k);
			smallest = 2*k;
		}
		if(2*k+1<position && mH[smallest]<mH[2*k+1]){ //check if the left child is lesser than right. If yes, we swap will right child.
				System.out.println("Setting smallest +1 to  " + 2*k+1);
			smallest = 2*k+1;
		}
			System.out.println("smallest =  " + smallest);
		if(smallest!=k){
			swap(k,smallest);
			sinkDown(smallest);
		}
				
	}
	public void swap(int a, int b){
		System.out.println("swapping " + mH[a] + " and " + mH[b]);
		int temp = mH[a];
		mH[a] = mH[b];
		mH[b] = temp;
	}
	
	
	public static void main(String args[]){
		int arrA [] = {3,2,1,7,8,4,16,12,9};
		System.out.print("Original Array : ");
		for(int i=0;i<arrA.length;i++){
			System.out.print("  " + arrA[i]);
		}
		BinaryMaxHeap m = new BinaryMaxHeap(arrA.length);
		System.out.print("\nMax-Heap : ");
		m.createHeap(arrA);		
		m.display();
		System.out.print("Extract Max :\n");
		m.extractMax();
		m.display();
		
	}
	
	public void display(){
		for(int i=1;i<mH.length;i++){
			System.out.print(" " + mH[i]);			
		}
		System.out.println("");
	}
	
}