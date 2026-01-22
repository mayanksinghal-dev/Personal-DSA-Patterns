package SlidingWindow;

/**
 * Invariant 1 - While we expand window, we maintain the constraint of k count flips. If validity failed, shrink your window to regain your validity
 * and also move forward.
 */

public class LC1004 {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int i = 0;
        int j = 0;
        while(j < nums.length){
            while(i <= j && nums[j]==0 && k==0){
                if(nums[i]==0) k++;
                i++;
            }
            if(nums[j]==0) k--;
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
