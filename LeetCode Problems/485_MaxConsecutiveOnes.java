public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int previouscount = 0;
        int maxconsecutiveones = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 1 ){
                maxconsecutiveones++;
            }
            else {
                previouscount = Math.max(previouscount,maxconsecutiveones);
                maxconsecutiveones = 0;
            }
        }
        return Math.max(maxconsecutiveones,previouscount);
    }
}