package SlidingWindow;

import java.util.*;

/**
 * Decision took - Increase until all p chars with exact freq won't be part of my window. Eliminate all possible prefixes which does not
 * contribute in the "P" freq. Check if window length is same as p length without losing any required character which contributes in frequency
 * of P. If yes, we got our window, store its ith pointer.
 *
 * Invariant - Its a mix of Fixed window and Validity maintaining window. Because we are here provided with fixed window i.e. P length
 * But we ain't properly using it. We are just considering a constraint of frequencies and characters should be equals to my window length
 *
 *
 */
public class LC438 {
    public List<Integer> findAnagrams(String s, String p) {
        //Started with storing all chars and there frequency.
        int[] freq = new int[26];
        for(char c : p.toCharArray()){
            freq[c-'a']++;
        }
        int j = 0;
        int i = 0;
        int missing = p.length();
        List<Integer> res = new ArrayList<>();
        //Traverse from left to right till the end
        while(j < s.length()){
            //If any char which contributes in p frequency, we consider it as missed once got in our window.
            char sj = s.charAt(j);
            if(freq[sj-'a'] > 0) missing--;
            freq[sj-'a']--; // Here if any char not contributing in p frequency, will head to negativity.
            //Once missing==0 means all P chars with all its frequency is in our window
            while(i <= j && missing==0){
                char si = s.charAt(i);
                freq[si-'a']++;
                //The moment my i is on some char which contributes to P frequency and we remove it to window, i will miss that char in my freq.
                if(freq[si-'a']>0) {
                    missing++;
                    //If my window is of length P, im sure that window is anagram of P. Because we have all chars of P and its frequency in the window
                    //and since window length is same, means there is no unwanted char in window which would disturb the length of window and would
                    // increase the length of window from P length
                    if(j-i+1==p.length()) res.add(i);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
