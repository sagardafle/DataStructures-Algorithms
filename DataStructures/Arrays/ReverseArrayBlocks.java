public class ReverseArrayBlocks {

    public static void main(String[] args) {
        int[] a = {
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9
        };
        int k = 3;
        int[] reversed = reverseInBlocks(a, k);
        for (int x: reversed) System.out.print(x + " ");
    }

    private static int[] reverseInBlocks(int[] A, int k) {
        for (int i = 0; i < A.length; i += k) {
            int left = i;
            // in case right larger than A.length
            int right = Math.min(i + k - 1, A.length - 1);

            // reverse sub array
            while (left < right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }

        return A;
    }
}