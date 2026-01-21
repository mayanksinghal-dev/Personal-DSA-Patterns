package Two_Pointers;

//Why does my solution given below works ?
/*
Idea / Proof (Gathered from Discussion Section of Leetcode from some intelligent programmers) :
    The widest container (using first and last line) is a good candidate, because of its width.
    Its water level is the height of the smaller one of first and last line. All other containers
    are less wide and thus would need a higher water level in order to hold more water. The smaller
    one of first and last line doesn't support a higher water level and can thus be safely removed from further consideration.
*/

//Approach (Two pointer Greedy (O(N))
public class LC11_Container_water {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0, j = n-1;

        int water = 0;
        while(i<j) {

            //start from the smallest one and calculate water
            int h = Math.min(height[i], height[j]);
            int w = j-i;
            int area = h*w;
            water = Math.max(water, area);

            if(height[i] < height[j])
                i++;
            else
                j--;
        }

        return water;
    }
}
