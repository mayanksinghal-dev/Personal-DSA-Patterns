package SlidingWindow;

import java.util.*;

/**
 * Intuition - This problem demands for all subarrays which have all unique elements within the array. My thought process was, i need to
 * traverse through the array and find the subarray where all unique elements available. To confirm i have all unique elements of array,
 * firstly i need to know how many unique elements are there in array. The expansion pointer, where i claim my window contains all unique
 * element, i can add all remaining elements and still my unique elements in window subarray count will remain same.
 * So -> Length - j helps us to know all the subarray we can possibly make from that expansion point.
 *
 * Invariant - Validation window - Within window [i..j], if window passing validation, we count those windows. Then we shrink and count
 * until validation wont fail. Then again expand window until window wont pass the validation
 */
public class LC2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) set.add(n);
        int i = 0;
        int j = 0;
        int uniqueEle = set.size();
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j < nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(i <= j && map.size()==uniqueEle){
                count+=(nums.length-j);
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i])<=0){
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return count;
    }
}
