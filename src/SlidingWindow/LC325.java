package SlidingWindow;

import java.util.*;

/**
 * Invariant - We carry prefix sum + hashmap, if sum - k found in prev, then find max value of it. If sum never seen before, then put that in map.
 * We will only add sum value once, so we can maintain max distance. If same sum found, and we update that with latest index, then it will become minimum window.
 * Since we updated sum map with latest index.
 *
 * To get the max window, the currIndex - prevIndex distance should be as high as possible.
 */
public class LC325 {
    public int maxSubArrayLen(int[] nums, int k) {
        int i = 0;
        int sum = 0;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        while(i < nums.length){
            sum+=nums[i];
            Integer prev = map.get(sum-k);
            if(prev!=null){
                max = Math.max(max,i-prev);
            }
            map.putIfAbsent(sum, i);
            i++;
        }
        return max;
    }
}
