package SlidingWindow;

import java.util.*;

/**
 * Intuition - Statement of the problem was like a story. But the main point was, we had to get maximum window of trees which follows the problem constraints.
 *
 * Invariant - We need to validate the window at each increasing window, and shrink if the constraint breaks.
 */
public class LC904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int i = 0;
        int j = 0;
        int lenFruits = fruits.length;
        int max = 0;
        while(j < lenFruits){
            int currFrJ = fruits[j];
            basket.put(currFrJ,basket.getOrDefault(currFrJ,0)+1);
            while(i < j && basket.size() > 2){
                int currFrI = fruits[i];
                basket.put(currFrI,basket.get(currFrI)-1);
                if(basket.get(currFrI)==0){
                    basket.remove(currFrI);
                }
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
