package SlidingWindow;

/**
 * Invariant - Fixed window, at each step the window contains length of k
 * Intuition - The problem directly states to maintain the window of length k.
 */

public class LC643 {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        double maxSum = Double.NEGATIVE_INFINITY;
        for(int i = 0;i<k;i++){
            sum+=nums[i];
        }
        maxSum = Math.max(sum,maxSum);
        for(int i = k;i<nums.length;i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum/k;
    }
}
