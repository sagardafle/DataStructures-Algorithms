/**
 * LOGIC : 
 * 1. First rotate entire array. 
 * 2. Then rotate array from 0 to k-1. 
 * 3. Finally rotate array from k to last element.
 */ 
public class Solution {
    public void rotate(int[] nums, int k) {
       k = k%nums.length;
       reverseArray(nums, 0, nums.length-1);
       reverseArray(nums, 0, k-1);
       reverseArray(nums, k, nums.length-1);
    }
       public void reverseArray(int nums[], int start, int end){
           int temp;
           while(start < end){
               temp = nums[start];
               nums[start++] = nums[end];
               nums[end--] = temp;
           }
       }
}