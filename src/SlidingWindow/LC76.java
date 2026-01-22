package SlidingWindow;

import java.util.*;

/**
 * Invariant - We need to maintain a window where a chars of "t" available,even duplicates. Once the window is built, shrink the window to eliminate chars not needed, so we can minimize the window.
 * Main invariant - At every step, we make sure we carry the minimum window with all t chars.
 */
public class LC76 {
    // By Myself
    public String minWindow(String s, String t) {
        Map<Character, Integer> freqT = new HashMap<>();
        Map<Character, Integer> freqW = new HashMap<>();
        for (char c : t.toCharArray()) {
            freqT.put(c, freqT.getOrDefault(c, 0) + 1);
        }
        int lenT = t.length();
        int lenS = s.length();
        int count = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        while (i < lenS) {
            while (i < lenS) {
                Integer freq = freqT.get(s.charAt(i));
                if (freq != null) break;
                i++;
            }
            while (j < lenS && count < lenT) {
                char jChar = s.charAt(j);
                Integer freqAtT = freqT.get(jChar);
                if (freqAtT != null) {
                    freqW.put(jChar, freqW.getOrDefault(jChar, 0) + 1);
                    Integer freqAtW = freqW.get(jChar);
                    if (freqAtW <= freqAtT) count++;
                }
                j++;
            }
            if (count == lenT && min > (j - i)) {
                min = Math.min(min, j - i);
                start = i;
                end = j;
            }
            if (i < lenS) {
                Integer freqIW = freqW.get(s.charAt(i));
                Integer freqIT = freqT.get(s.charAt(i));
                freqW.put(s.charAt(i), freqIW - 1);
                if (freqIW - 1 < freqIT) count--;
            }
            i++;
        }
        if (start == -1) return "";
        return s.substring(start, end);
    }

    //By ChatGPT
    public String minWindowGPT(String s, String t) {
        if (t.length() > s.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) need[c]++;

        int missing = t.length();          // how many total chars still needed
        int left = 0;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (need[c] > 0) missing--;    // we used a needed char
            need[c]--;                     // always decrement (extra chars go negative)

            // window is valid when nothing is missing
            while (missing == 0) {
                int len = right - left + 1;
                if (len < bestLen) {
                    bestLen = len;
                    bestStart = left;
                }

                char lc = s.charAt(left);
                need[lc]++;                // put left char back
                if (need[lc] > 0) missing++; // now we're missing one again
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
