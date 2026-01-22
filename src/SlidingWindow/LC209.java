package SlidingWindow;

/**
 * Brute force - Build all possible subarrays and calculate there sum. O(N^2)
 *
 * Invariant - With each increasing window, we make sure window contains sum is in the constraints of target.
 */
public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum+=nums[j];
            while(i <= j && sum >= target){
                min = Math.min(min,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
