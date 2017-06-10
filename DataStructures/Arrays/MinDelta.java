/**The best you can do is sort both lists (assuming unsorted), then merge them together, keeping track of the difference between the two elements of each array at each step of the merge. O(m log m + n log n) time, where m is the size of list a and n is the size of list b.*/

public class MinDelta {
    private int minDelta = Integer.MAX_VALUE;

    public static void main(String[] args) {
        MinDelta m = new MinDelta();
    }

    public MinDelta() {
        int[] a1 = new int[] {
            -3, 1, 999
        };
        int[] a2 = new int[] {
            -1, 2, 3
        };
        java.util.Arrays.sort(a1);
        java.util.Arrays.sort(a2);
        int min = merge(a1, a2);
        System.out.print(min + " ");
    }

    public static int merge(int[] a, int[] b) {
        int mindiff = Integer.MAX_VALUE;
        int[] answer = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length)
            if (a[i] < b[j]) {
                if (a[i] - b[j] < mindiff) mindiff = a[i] - b[j];
                answer[k++] = a[i++];

            } else {
                if (b[j] - a[i] < mindiff) mindiff = b[j] - a[i];
                answer[k++] = b[j++];

            }

        while (i < a.length)
            answer[k++] = a[i++];


        while (j < b.length)
            answer[k++] = b[j++];

        return mindiff;
    }
}