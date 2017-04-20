import java.util.*;

public class KthLargest {
    public static void main(String[] args) {
        int arr[] = {
            12,
            3,
            5,
            7,
            19
        };
        int n = arr.length;
        int k = 2;
        System.out.println(kthLargest(arr, n, k));
    }

    public static int kthLargest(int[] a, int n, int k) {
       
        PriorityQueue < Integer > pq = new PriorityQueue < Integer > (k + 1);

        for (int el: a) {
            pq.add(el);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}
