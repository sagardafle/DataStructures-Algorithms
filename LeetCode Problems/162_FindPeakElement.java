/**
 * A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

/**
 * Solution: if there's only one element in the array, return that index. 
 *           3 cases: 
 *           1. [1,2] return index 0 (first if condition)
 *           2. [2,1] return index 0 (second if condition)
 *           3. [1,3,2,1] return 1 (last if condition)
*/

public class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length ==1) return 0;
        for(int i=0;i<=nums.length-1;i++){
            if(i==0){
                if(nums[i]>nums[i+1]) return i;  //return 0 for [2,1]
            } else if (i == nums.length-1){
                if(nums[i]>nums[i-1]) return i;  //return 0 for [1,2]
            } else if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        return 0;
    }
}