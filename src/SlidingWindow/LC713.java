package SlidingWindow;

/**
 * Invariant - Expand if constraints passed, shrink when constraints failed. Simple (At most + count windows) sliding window problem.
 *
 * Intuition - Count all possible sliding window asks for formula to count all subarrays ending at index right = right - left + 1;
 * We expand if product < k, count all possible subarrays from that index within the window. So, if S1 is a subarray and constraints are
 * passed, then S2 (Subarray of S1) is also validated.
 * We shrink if product >= k in internal while loop.
 */
public class LC713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int prod = 1;
        int count = 0;
        while(j < nums.length){
            prod = prod * nums[j];
            while(i <=j && prod >= k){
                prod = prod / nums[i];
                i++;
            }
            if(prod < k) count+=j-i+1;
            j++;
        }
        return count;
    }
}
