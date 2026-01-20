package Two_Pointers;

/**
 * Two pointers simply used for finding relations between limited number of elements.

 * Problem generally defines relations like operation/arithmetic, distance, values.
 * Sorted order - Simple decision

 * Earlier i confused it if numbers contain -ve values, but the logic remained same on dry run.

 * TC-  O(N) - Single while loop
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                return new int[]{i+1,j+1};
            }
            else if(sum > target) j--;
            else i++;
        }
        return new int[]{-1,-1};
    }
}