package SlidingWindow;

import java.util.*;

public class LC930 {
    //Approach 1 - Using Prefix sum + hashmap-> Used to get sum==k problems in O(n) Time and space complexity;
    public int numSubarraysWithSum1(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            sum += nums[j];
            if (sum == goal) count++;
            if (map.get(sum - goal) != null) {
                int past = map.get(sum - goal);
                count += past;
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            j++;
        }
        return count;
    }

    //Approach 2 - Using Name 4B: At most sliding window + Difference trick ->
    // Used to get sum==k problems in O(n) Time and O(1) space complexity;
    //Main approach -> count(sum == k) = count(sum<=k) - count(sum<=k-1);
    private int dynamicSubarrayWithSum(int[] nums, int goal) {
        int sum = 0;
        int count = 0;
        int j = 0;
        int i = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (i <= j && sum > goal) {
                sum -= nums[i];
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        int k1 = dynamicSubarrayWithSum(nums, goal);
        int k2 = dynamicSubarrayWithSum(nums, goal - 1);
        return k1 - k2;
    }
}
