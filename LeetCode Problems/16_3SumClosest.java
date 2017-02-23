public class Solution {
    public int threeSumClosest(int[] nums, int target) {
         Arrays.sort(nums);
        int i, j, k, mindiff ,sum,lowestsum;
        i=j=k=sum=lowestsum=0;
        mindiff = Integer.MAX_VALUE;
        for(i=0;i<nums.length -2; i++){
            if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
            j = i+1; k = nums.length-1;
            
            while(j<k){
                // System.out.println("i "+i);
                // System.out.println("j "+j);
                // System.out.println("k "+k);
                 sum = nums[i]+nums[j]+nums[k];
                //  System.out.println("sum=========== "+sum);
                if(sum == target){
                    j++;k--;
                    while(j<k && nums[j] == nums[j-1]) j++; //avoid duplicates
                    while(j<k && nums[k] == nums[k+1]) k--; //avoid duplicates
                } else if(sum>target){
                           k--;
                    } else {
                           j++;
                       }
                       if(Math.abs(sum-target)< mindiff){
                           mindiff = Math.abs(sum-target);
                           lowestsum = sum;
                       } 
                            // System.out.println("MD=========== "+mindiff);
            }
        }
     return lowestsum;
    }
}