/**
 * Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

    12 + 92 = 82
    82 + 22 = 68
    62 + 82 = 100
    12 + 02 + 02 = 1
*/

/**
 * Solution:The idea is to use one hash set to record sum of every digit square of every number occurred. 
 * Once the current sum cannot be added to set, return false; once the current sum equals 1, return true;
 * */
 
 public class Solution {
    public boolean isHappy(int n) {
       int squaresum,remainder;
       Set<Integer> data = new HashSet<Integer>();
       while (data.add(n)){
           squaresum = 0;
           while(n>0){
               remainder = n%10;
               squaresum += remainder*remainder;
               n = n/10;
           }
           if(squaresum ==1) return true;
           else n = squaresum;
       }
       return false;
    }
}