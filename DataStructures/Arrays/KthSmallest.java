import java.util.*;

public class KthSmallest {
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
        System.out.println(kthSmallest(arr, n, k));
    }

    public static int kthSmallest(int[] a, int n, int k) {
        Comparator < Integer > comparator = new PQComparator();
        PriorityQueue < Integer > pq = new PriorityQueue < Integer > (k + 1, comparator);

        for (int el: a) {
            pq.add(el);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.poll();
    }
}


class PQComparator implements Comparator < Integer > {
    @Override
    public int compare(Integer x, Integer y) {

        if (x < y) {
            return 1;
        }
        if (x > y) {
            return -1;
        }
        return 0;
    }
}