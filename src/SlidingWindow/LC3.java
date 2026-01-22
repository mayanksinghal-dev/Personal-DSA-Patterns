package SlidingWindow;

import java.util.*;

/**
 * Invariant 1 - While moving through the array, i make sure my window remain within the constraints. Increase window if constraints
 * valid else shrink window. You wont move further until your window is constraint valid.
 */
public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0, right =0, max = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(seen.contains(c)){
                seen.remove(s.charAt(left));
                left++;
            }
            else{
                seen.add(c);
                right++;
            }
            max = Math.max(max,right-left);
        }
        return max;
    }
}
