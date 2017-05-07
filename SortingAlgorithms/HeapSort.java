/**
 * in-place sorting algorithm. 
 * Complexity : o(nlogn)
 * LOGIC: 
 * 1. Heapify phase: Build max-heap (using bottom-up approach)
 * 2. Sort-down phase: Repeatedly exchange max element(root) with the last element in the heap.
 */
public class HeapSort {
    int a[] = {
        3, 6, 9, 10, 7, 4, 2
    };
    int N;
    public static void main(String args[]) {
        HeapSort heapobj = new HeapSort();
        heapobj.maxheapify(); //HEAPIFY
        System.out.println("After heapifying ==");
        heapobj.display();
        System.out.println("After sorting ==");
        heapobj.sort(); // SORT
        heapobj.display();
    }
    public void maxheapify() {
        N = a.length;
        for (int k = N / 2; k >= 1; k--) { //we always start with N/2 index
            sink(a, k - 1, N); //k-1 as the array index starts with 0 and not 1.
        }
    }
    public void sink(int a[], int k, int N) {
        System.out.println("=============== \n k =  " + k);

        int smallest = k;
        if (2 * k < N && a[smallest] < a[2 * k]) {
            smallest = 2 * k;
            System.out.println("Setting smallest to  " + smallest);
        }

        if ((2 * k + 1) < N && a[smallest] < a[2 * k + 1]) { //check if the left child is lesser than right. If yes, we swap will right child.
            smallest = 2 * k + 1;
            System.out.println("Setting smallest to  " + smallest);
        }
        System.out.println("smallest =  " + smallest);
        if (smallest != k) {
            swap(k, smallest);
            sink(a, smallest, N);
        }
    }

    public void sort() {
        while (N > 1) {
            swap(0, N - 1); //swap the root element with the last element
            sink(a, 0, --N); //do sink so as to heapify the tree.
        }
    }

    public void swap(int x, int y) {
        System.out.println("swapping " + a[x] + " and " + a[y]);
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public void display() {
        for (int l = 0; l < a.length; l++) {
            System.out.print(a[l] + " ");
        }
        System.out.println();
    }
}