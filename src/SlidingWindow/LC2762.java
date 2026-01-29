package SlidingWindow;

import java.util.*;

public class LC2762 {
    /** Better - Not optimal
     * Invariant - While traversing through the array, if validation fails i.e. Math.abs(max- min) > 2, then shrink the window until validation passes.
     *
     * Tc - O(n Log n), SC - O(n)
     *
     */
    class Solution {
        record Pair(int ind, int val) {
        };

        public long continuousSubarrays(int[] nums) {
            PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
            PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.val - a.val);
            int i = 0;
            int j = 0;
            long count = 0;
            int len = nums.length;
            while (j < len) {
                minHeap.offer(new Pair(j, nums[j]));
                maxHeap.offer(new Pair(j, nums[j]));
                Pair minTop = minHeap.peek();
                Pair maxTop = maxHeap.peek();
                while (i < j && Math.abs(maxTop.val() - minTop.val()) > 2) {
                    i++;
                    while (minTop.ind() < i || maxTop.ind() < i) {
                        if (minTop.ind() < i) {
                            minHeap.poll();
                            minTop = minHeap.peek();
                        }
                        if (maxTop.ind() < i) {
                            maxHeap.poll();
                            maxTop = maxHeap.peek();
                        }
                    }
                }
                count += (j - i + 1);
                j++;
            }
            return count;
        }
    }
}
