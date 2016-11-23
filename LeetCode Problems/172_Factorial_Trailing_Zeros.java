/**
 * 
Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
*/

/**
 * LOGIC: 
 * 1. We keep on dividing n by 5 unless n becomes less than 5.
   2. We keep on adding the value of count to n/5
*/ 
public class Solution {
    public int trailingZeroes(int n) {
        int count=0;
          while (n>=5) {
            n/=5;
            count+=n;
          }
          return count;
    }
}