package Two_Pointers;

/**
 * The intuition of this problem is, we manage 2 pointers since we just need to know the base and end of a mountain.
 * length = end-base+1;
 *
 * invariant - Everytime we find a base, we start an end from it. When we find the end of a mountain, we calculate the length and
 * assign it as the base of next possible mountain.
 *
 *
 *
 * A base is a valley, which has higher values on both sides.
 */
public class LC845_Longest_Mountain {
    public int longestMountain(int[] A) {
        int N = A.length;
        int ans = 0, base = 0;
        while (base < N) {
            int end = base;
            // if base is a left-boundary
            if (end + 1 < N && A[end] < A[end + 1]) {
                // set end to the peak of this potential mountain
                while (end + 1 < N && A[end] < A[end + 1]) end++;

                // if end is really a peak
                if (end + 1 < N && A[end] > A[end + 1]) {
                    // set end to the right-boundary of mountain
                    while (end + 1 < N && A[end] > A[end + 1]) end++;
                    // record candidate answer
                    ans = Math.max(ans, end - base + 1);
                }
            }
            base = Math.max(end, base + 1);
        }
        return ans;
    }
}
