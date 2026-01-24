package SlidingWindow;

import java.util.*;

/**
 * Count of subarrays with sum == k, nums[i] can be -ve also so we cannot rely on trick (names 4b) invariant.
 */
public class LC560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int pointer = 0;
        int prefixSum = 0;
        map.put(prefixSum,1);
        while(pointer<nums.length){
            prefixSum+=nums[pointer];
            int previousPrefix = prefixSum-k;
            if(map.get(previousPrefix)!=null){
                count+=map.get(previousPrefix);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
            pointer++;
        }
        return count;
    }
}
