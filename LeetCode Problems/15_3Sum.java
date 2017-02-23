/**
 * LOGIC : 
 * 1. We first sort the array. 
 * 2. Now we have 3 pointers. i = 0, j=i+1, k = nums.length-1. 
 * 3. We add the values at these indexes. 
 *    3.1 If sum == 0 
 *          3.1.1 We add these values in list.
 *          3.1.2 We increment j and decrement k. 
 *          3.1.3 Now, to handle duplicates, we need to check if the elements adjacent to j and k are same. If they are same, there's no                 point in checking them in next iteration. So we move ahead by incrememnt j and decrementing k.
 *   3.2 If sum > 0 
 *          3.2.1 It must be the element at last index(k) which is making sum>0 , so we decrement k.
 *   3.3 If sum <0 
 *          3.2.2 It must be the element at jth index which is making sum<0 , so we increment k.
 */ 
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int i, j, k;
        i=j=k=0;
        
        for(i=0;i<nums.length -2; i++){
            if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates
            j = i+1; k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    List<Integer> tmplist = new ArrayList<Integer>();
                    tmplist.add(nums[i]);
                    tmplist.add(nums[j]);
                    tmplist.add(nums[k]);
                    result.add(tmplist);
                    j++;k--;
                    /**
                     * Once we get a list added in the result, we need to check if the elements adjacent to j and k are same. If they are same, there's no point in checking them in next iteration. So we move ahead by incrememnt j and decrementing k.
                     */ 
                    while(j<k && nums[j] == nums[j-1]) j++; //avoid duplicates
                    while(j<k && nums[k] == nums[k+1]) k--; //avoid duplicates
                } else if(sum>0) k--;
                    else j++;
                
            }
        }
        return result;
    }
}