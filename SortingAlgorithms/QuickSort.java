/**
 *  When Quick Sort behaves in Worst Case ?
 * 
 * The answer depends on strategy for choosing pivot. 
 * When leftmost (or rightmost) element is chosen as pivot, the worst occurs in following cases.

1) Array is already sorted in same order.
2) Array is already sorted in reverse order.
3) All elements are same (special case of case 1 and 2)

Since these cases are very common use cases, 
the problem was easily solved by 
1. choosing either a random index for the pivot, 
2. choosing the middle index of the partition or (especially for longer partitions) 
3. choosing the median of the first, middle and last element of the partition for the pivot. 

With these modifications, the worst case of Quick sort has less chances to occur, 
but worst case can still occur if the input array is such that the maximum (or minimum) element is always chosen as pivot.
*/

/*Reference: https://www.youtube.com/watch?v=COk73cpQbFQ*/
public class QuickSort {
    /* The main function that implements QuickSort()
    arr[] --> Array to be sorted,
    low  --> Starting index,
    high  --> Ending index */
    void quicksort(int A[], int start, int end) {
        int pIndex;
        if (start < end) {
            pIndex = partition(A, start, end);
            quicksort(A, start, pIndex - 1);
            quicksort(A, pIndex + 1, end);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    int partition(int A[], int start, int end) {
        int pivot, i, pIndex, temp, temp2;
        pivot = A[end];
        pIndex = start;
        for (i = start; i < end; i++) {
            if (A[i] <= pivot) {
                //Swap A[i] with the A[pIndex]
                swap(i, pIndex);
                //move pIndex to right
                pIndex = pIndex + 1;
            }
        }
        /*Finally swap the pivot with the element at A[pIndex]*/
        swap(pIndex, end);
        return pIndex;
    }

    public void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    static int[] arr;
    public static void main(String args[]) {
        arr = new int[] {
            10,
            7,
            8,
            9,
            1,
            5
        };
        int n = arr.length;

        QuickSort ob = new QuickSort();
        ob.quicksort(arr, 0, n - 1);

        System.out.println("Sorted array");
        printArray(arr);
    }
}