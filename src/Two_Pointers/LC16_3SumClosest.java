package Two_Pointers;

/**
 * Similar to another variants of 2/3/4 sum where we have limited elements find limited elements which reaches a target
 */

import java.util.Arrays;

public class LC16_3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int closest = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0;i<len;i++){
            int j = i+1;
            int k = len-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                int currDist = Math.abs(target-sum);
                if(currDist < closest){
                    closest = currDist;
                    res = sum;
                }
                if(currDist==0) return sum;
                else if(target-sum < 0) k--;
                else if(target - sum > 0) j++;
            }
        }
        return res;
    }
}
