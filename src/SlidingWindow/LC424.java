package SlidingWindow;

import java.util.*;

/**
 * Intuition - While traversing through the array, i will carry my window. Within a window, max we can accept
 * (Difference = Window size - Max freq of a character, difference <= k).
 * If the count of different characters (Difference) increase from k, we shrink the window.
 *
 * Main point - Why we are not decreasing the maxFreq when shrinking the window.
 * because - Whatever the maxFreq we have got, window size can only increase if we get higher maxFreq than current maxFreq because
 * difference = winSize - maxFreq, if we decrease the maxFreq(while shrinking) and increase the winSize (while expanding), we can
 * never get better solution because difference would have increased. So eventually we will target the higher frequency only, might
 * be from some other element or same, so this proves that lower maxFreq will never provide us better solution.
 *
 * Invariant 1 - With each increasing window, we carry the constraint of K different characters. If constraint broke, shrink the window.
 */
public class LC424 {
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int maxFreq = 0;
        while(j < s.length()){
            char currJ = s.charAt(j);
            map.put(currJ,map.getOrDefault(currJ,0)+1);
            int winSize = j-i+1;
            maxFreq = Math.max(maxFreq,map.get(currJ));
            int diff = winSize - maxFreq;
            while(i <= j && diff > k){
                char currI = s.charAt(i);
                map.put(currI,map.get(currI)-1);
                i++;
                winSize = j-i+1;
                diff = winSize - maxFreq;
            }
            max = Math.max(winSize,max);
            j++;
        }
        return max;
    }
}
