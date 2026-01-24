package SlidingWindow;

import java.util.Set;

/**
 * Invariant - Fixed window size.
 */
public class LC1456 {
    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) count++;
        }
        int i = k;
        int maxVowel = count;
        while (i < s.length()) {
            if (set.contains(s.charAt(i - k))) count--;
            if (set.contains(s.charAt(i))) count++;
            maxVowel = Math.max(maxVowel, count);
            if (maxVowel == k) return maxVowel;
            i++;
        }
        return maxVowel;
    }
}
