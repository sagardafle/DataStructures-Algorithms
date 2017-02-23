public class Solution {
    /**
     * LOGIC:
     * 1. Set i = 1 if array length >1. 
     * 2. Now, iterate over the array values.
     *   2.1 If 'value' > a[i-1] //compare with previous index.
     *   2.2 Replace the next array index with 'value'.
     */ 
    public int removeDuplicates(int[] nums) {
       int i = (nums.length>0) ?  1:0;
       for (int val:nums){
           if(val>nums[i-1]) {
               nums[i++] = val;
           }
       }
       return i;
    }
}