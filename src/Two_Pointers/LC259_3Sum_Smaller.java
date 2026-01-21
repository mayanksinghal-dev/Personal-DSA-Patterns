package Two_Pointers;

import java.util.Arrays;

public class LC259_3Sum_Smaller {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for(int i = 0;i<len;i++){
            int j = i+1;
            int k = len-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < target){
                    int dist = k-j;
                    count+=dist;
                    j++;
                }
                else if(sum >=target) k--;
            }
        }
        return count;
    }
}
