/**
 * http://codereview.stackexchange.com/questions/101078/merge-k-sorted-arrays?newreg=fdbe5f95726c43fe962506e6610ff12d
 * Merge K Sorted Arrays in Java
 * This problem can be solved by using a heap. The time is O(nlog(n)).
 * LOGIC:
 * 1. Create a HeapItem class including a comparator for sorting
 * 2. Create a PQ of type HeapItem.
 * 3. Insert the values from the array into PQ in a loop.
 * 4. Create a "result" list with size = totalnoofelements in all the elements
 * 5. Remove elements from PQ until it is null.
 * 6. Insert the value in (5) to the "result" list.
 */

import java.util.*;

public class MergeKSortedArrays {

    public static class HeapItem implements Comparable < HeapItem > {
        int[] array;
        int index; // the index of current element               
        public HeapItem(int[] arr, int index) {
            this.array = arr;
            this.index = index;
        }

        /**
         * The general contract of Comparable.compareTo(o) is to return
        
        a positive integer if this is greater than the other object.
        a negative integer if this is lower than the other object.
        0 if this is equals to the other object.
        */
        @
        Override
        public int compareTo(HeapItem h) {
            if (array[index] < h.array[h.index]) {
                return -1;
            } else if (array[index] > h.array[h.index]) {
                return 1;
            } else {
                return 0;
            }
        }

    }
    public static List < Integer > mergeArrays(int[][] arrays) {
        if (arrays == null || arrays.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        // priority queue is heap in Java
        PriorityQueue < HeapItem > pq = new PriorityQueue < HeapItem > ();
        // add arrays to the heap
        int outputSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            pq.add(new HeapItem(arrays[i], 0));
            outputSize += arrays[i].length;
        }
        List < Integer > result = new ArrayList < Integer > (outputSize); //create a output list with size = totalnoofelements
        
        while (!pq.isEmpty()) {
            HeapItem current = pq.remove();
             System.out.println("Current index: "+current.index);
             System.out.println("=======Adding to list ===== "+current.array[current.index]);
            result.add(current.array[current.index]);
            if (current.index < current.array.length - 1) {
                current.index++;
                pq.add(current);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {
            1, 3, 5, 7
        };
        int[] arr2 = {
            2, 4, 6, 8
        };
        int[] arr3 = {
            0, 9, 10, 11
        };
        System.out.println(mergeArrays(new int[][] {
            arr1, arr2, arr3
        }));
    }
}