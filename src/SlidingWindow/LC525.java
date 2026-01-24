package SlidingWindow;

import java.util.*;

/**
 * Decision - We assumed 0 as -1 to counter the sum + 1. Since the question demands window with max equal 0 and 1. If sum found in past,
 * then sum(right - left) == 0. So converting 0 to -1 in array, we converted the problem into max window with sum== 0.
 *
 * Invariant - We carry the prefix sum in hashmap and find window length when window sum == 0;
 */
public class LC525 {
    public int findMaxLength(int[] nums) {
        int i = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        map.put(0,-1);
        while(i < nums.length){
            sum+= nums[i]==0 ? -1 : 1;
            if(map.get(sum)!=null){
                int left = map.get(sum);
                max = Math.max(max, i - left);
            }
            else{
                map.put(sum,i);
            }
            i++;
        }
        return max;
    }
}
