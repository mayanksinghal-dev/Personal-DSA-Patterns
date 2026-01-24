package SlidingWindow;

/**
 *
 */
public class GFG5313 {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int sum = 0;
        int max = 0;
        int j = 0;
        while(j < arr.length){
            sum+=arr[j];
            if(j+1 >= k){
                max = Math.max(max,sum);
                sum-=arr[j+1-k];
            }
            j++;
        }
        return max;
    }
}
