package SlidingWindow;

public class LC1248 {
    public static int dynamicGoals(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }
        int count = 0;
        int oddCount = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] % 2 != 0 && oddCount <= goal) {
                oddCount++;
            }
            while (left <= right && oddCount > goal) {
                if (nums[left] % 2 != 0) {
                    oddCount--;
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        int count1 = dynamicGoals(nums, k);
        int count2 = dynamicGoals(nums, k - 1);
        return count1 - count2;
    }
}
