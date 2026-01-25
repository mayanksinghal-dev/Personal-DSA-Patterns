package SlidingWindow;

import java.util.*;

/**
 * Note : * Whenever question demands for count of subarray based on data seen in the past and you cannot decide when to move right or left.
 * Think in terms of prefix sum or At most sliding window + Difference trick.
 * * To get all subarrays ending at index right = right - left + 1;
 * <p>
 * Problem statement : Given an integer array nums and an integer k, return the number of good subarrays of nums.
 * A good array is an array where the number of different integers in that array is exactly k.
 * For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
 * A subarray is a contiguous part of an array.
 * <p>
 * <p>
 * Idea - Since this problem clearly demands of count of subarrays with unique elements == k. We can simply think in terms of
 * Count(elements <=k) - Count(elements <=k-1) = Count(elements==k).
 * <p>
 * Invariant - At most sliding window + difference trick
 * Within your window, you carry at most K unique elements. If in current window unique elements > k, shrink window to regain validation.
 * Constraint - At most k unique elements
 * Validation - unique elements in window <= k, if limit exceeded, validation failed.
 * Regain validation - Shrink until window gets into limit of k.
 */
public class LC992 {
    private int dynamicSubarray(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (j < nums.length) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while (map.size() > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return dynamicSubarray(nums, k) - dynamicSubarray(nums, k - 1);
    }
}
