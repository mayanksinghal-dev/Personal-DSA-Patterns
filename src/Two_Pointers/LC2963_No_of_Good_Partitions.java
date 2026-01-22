package Two_Pointers;

import java.util.*;

/**
 * All numbers seen so far must be fully contained before the cut.
 *
 * This problem was not solved by me. I must retry this later.
 * Core intuition: For each window (ij), j is the farthest last occurrence of any value we have seen so far.
 * All the same elements of the given array must be in single subarray. For eg [1,2,1,3,4] -> here [1,2,1] must be in same array
 * so other subarrays wont have that clashing numbers and invalidate the solution.
 *
 *
 * This invariant answers one question only:
 * “Is it legal to cut here?”
 *
 */
public class LC2963_No_of_Good_Partitions {
    private static final int MOD = 1_000_000_007;

    public int numberOfGoodPartitions(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        //We get to know the last index of each element. So whenever we see an element, we move j to its last index to
        //include that element in current subarray.
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int count = 1;
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            j = Math.max(j, map.get(nums[i]));
            if (i == j && i != nums.length - 1) {
                count = (int) ((count * 2L) % MOD);
            }
        }
        return count;
    }
}
