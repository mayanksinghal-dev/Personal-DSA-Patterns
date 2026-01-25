package SlidingWindow;

import java.util.*;

/**
 * Key decision -> If remainder of 2 subarrays s2,s1 is same, then remainder of difference of those 2 subarrays is 0, when divisor is k in both cases.
 *
 * INVARIANT - Maintain the prefix remainder and compare with current sum remainder. If matched means Remainder(s1-s2)=0, return true.
 */
public class LC523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length < 2) return false;
        int sum = 0;
        int i = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        while(i < nums.length){
            sum+=nums[i];
            int remainder = sum%k;
            if(map.get(remainder)!=null){
                if(map.get(remainder) <= i-2) return true;
            }
            else{
                map.put(remainder,i);
            }
            i++;
        }
        return false;
    }
}
