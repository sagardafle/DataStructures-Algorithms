/**http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such-that-arrj-arri/
 */
 
 /**First find the difference between the adjacent elements of the array 
  * and store all differences in an auxiliary array diff[] of size n-1. 
  * Now this problems turns into finding the maximum sum subarray of this difference array.
  * Improvization: We can modify the above method to work in O(1) extra space. 
  * Instead of creating an auxiliary array, we can calculate diff and max sum in same loop. Following is the space optimized version.
  */
  
class LargestDiffrence {
    public static void main(String[] args) {
        int[] arr = {
            2,
            3,
            10,
            6,
            4,
            8,
            1
        };
        System.out.println("max_diff " + maxDiff(arr, arr.length));
    }

    static int maxDiff(int arr[], int n) {
        // Initialize diff, current sum and max sum
        int diff = arr[1] - arr[0];
        int curr_sum = diff;
        int max_diff = curr_sum;

        for (int i = 1; i < n - 1; i++) {
            // Calculate current diff
            diff = arr[i + 1] - arr[i];

            // Calculate current sum
            if (curr_sum > 0)
                curr_sum += diff;
            else
                curr_sum = diff;

            // Update max sum, if needed
            if (curr_sum > max_diff)
                max_diff = curr_sum;
        }

        return max_diff;
    }
}