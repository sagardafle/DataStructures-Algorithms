public class Solution {
    public int maxSubArray(int[] A) {
       int n = A.length;
       int[] currentmax = new int[n];//currentmax[i] means the maximum subarray ending with A[i];
        currentmax[0] = A[0];
        int max = currentmax[0];
        
        for(int i = 1; i < n; i++){
            currentmax[i] = Math.max(A[i], A[i] + currentmax[i - 1]);
            max = Math.max(max, currentmax[i]);
        }
        
        return max;
    }
}