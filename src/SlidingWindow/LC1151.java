package SlidingWindow;

/**
 * Decision - I expand the window until all 1s can group together within that window. Now we need to know the vacancy within the window.
 * Vacancy within a window means the no's of 0s in the window which can be swapped by 1s out of the window. The lower the vacancy,
 * the lower the swaps.
 *
 * Invariant - We carries fixed window of size = no's of 1s in original array. Less no of vacancies means less numbers of swaps.
 */
public class LC1151 {
    public int minSwaps(int[] data) {
        int count1s = 0;
        for(int i : data){
            if(i==1) count1s++;
        }
        int vacancy = 0;
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(j < data.length){
            int winSize = j-i+1;
            int dataJ = data[j];
            if(dataJ==0) vacancy++;
            if(winSize==count1s){
                min = Math.min(min,vacancy);
                int dataI = data[i];
                if(dataI==0) vacancy--;
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}
