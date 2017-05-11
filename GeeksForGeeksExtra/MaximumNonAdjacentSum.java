/**
 * Sum[i] represents the maximum sum of non-consecutive elements from arr[0]..arr[i].
 * */

class MaximumNonAdjacentSum {
    /*Function to return max sum such that elements are non-adjacent
      are adjacent */
      
    int noncontiguoussum(int[] arr, int size) {
        int[] sum = new int[size];
        int i;

        for (i = 0; i < size; i++) {
            if (i == 0) {
                sum[0] = arr[0];
            } else if (i == 1) {
                sum[1] = Math.max(sum[0], arr[1]);
            } else {
                sum[i] = Math.max(sum[i - 2] + arr[i], sum[i - 1]); // we make sure we pick consecutive elements only.
            }
        }
        
        printsumarray(sum);
        return sum[size - 1];
    }


    // Driver program to test above functions
    public static void main(String[] args) {
        MaximumNonAdjacentSum sum = new MaximumNonAdjacentSum();
        int arr[] = new int[] {
           10,30,6,7,4,2 //30,7 and 2
        };
        System.out.println(sum.noncontiguoussum(arr, arr.length));
    }
    
    public void printsumarray(int[] arr){
              int sum = 0;
              for (int i=0;i<arr.length;i++){
                        System.out.print(arr[i]+" ");
              }
    }
}