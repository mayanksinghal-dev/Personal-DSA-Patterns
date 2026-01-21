package Two_Pointers;

/**
 * This problem simply demands me to know how many subarrays can be formed which ends at index J.
 * It contains simple maths.
 * subarray from index i to ends at index j = j-i;
 */
public class LC3101_CountAlternatingSubarrays {
    public long countAlternatingSubarrays(int[] nums) {
        int len = nums.length;
        int i = 0;
        int j = 0;
        long res = 0;
        while (j < len) {
            if (j > 0 && nums[j] != nums[j - 1]) {
                res += (j - i);
            } else {
                i = j;
            }
            res++;
            j++;
        }
        return res;
    }
}
