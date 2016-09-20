public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int[] returnindex = new int[2];
        // for(int i=0;i<nums.length;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         if(nums[i]+nums[j] == target){    //O(n2)
        //             returnindex[0] = i;
        //             returnindex[1] = j;
        //             break;
        //         }
        //     }
        // }
        // return returnindex;
        
       
        HashMap<Integer,Integer> myHashMap = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            myHashMap.put(nums[i],i);
        }
        
         for(int i=0;i<nums.length;i++){
             int complement = target-nums[i];
             if(myHashMap.containsKey(complement) && myHashMap.get(complement)!= i){
                 return new int[]{ i , myHashMap.get(complement) };
             }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}