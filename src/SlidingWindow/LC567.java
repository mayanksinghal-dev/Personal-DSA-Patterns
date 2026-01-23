package SlidingWindow;

/**
 * It's completely same as LC76
 * Intuition - While traversing through the string s2, Once we got all the s1 chars in the window, we will shrink the window until all unneeded prefixes
 * won't eliminate. Once prefix is eliminate, we just identify if the length of window is same as S1 length. Since we know that all s1 chars are in my window,
 * any unwanted char (Like s1 char with extra frequency or char not available in s1) would disturb the length of the window vs length of S1 string.
 *
 *
 * Invariant - While increasing the window, we validate if all s1 elements are in window. Once all s1 chars in window, shrink the window making sure no s1 element exits.
 * Compare the length of s1 to the window.
 */
public class LC567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(char c : s1.toCharArray()){
            freq[c-'a']++;
        }
        int i = 0;
        int j = 0;
        int lenS2 = s2.length();
        int lenS1 = s1.length();
        int count = lenS1;
        while(j < lenS2){
            char sj = s2.charAt(j);
            if(freq[sj-'a']>0) count--;
            freq[sj-'a']--;
            while(i <= j && count==0){
                char si = s2.charAt(i);
                if(freq[si-'a']==0){
                    int currLen = j-i+1;
                    if(currLen == lenS1) return true;
                    count++;
                }
                freq[si-'a']++;
                i++;
            }
            j++;
        }
        return false;
    }
}
