/**
 * 136. Single Number   QuestionEditorial Solution  My Submissions
Total Accepted: 167412
Total Submissions: 321363
Difficulty: Easy
Contributors: Admin
Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


*/

public class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i=0;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;
    }
}