package SlidingWindow;

import java.util.*;

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
