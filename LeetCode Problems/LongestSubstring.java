/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0

Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5

**/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) { 
        int[] answer = new int[nums1.length+nums2.length];
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length){
        if (nums1[i] < nums2[j])       
            answer[k++] = nums1[i++];
        else        
            answer[k++] = nums2[j++];            //merge two arrays in a sorted way   
        }
        while (i < nums1.length)  
            answer[k++] = nums1[i++];
    
        while (j < nums2.length)    
            answer[k++] = nums2[j++];
        
            double median = 0.0f;
            if (answer.length%2==0) median = (double) (answer[answer.length/ 2] + answer[answer.length/2-1])/2;
            else median = (double) answer[answer.length/2];
        return median;
    }
}