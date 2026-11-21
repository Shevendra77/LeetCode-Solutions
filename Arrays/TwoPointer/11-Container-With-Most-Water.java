class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length-1;
        int maxWater = 0;

        while(left < right)
        {
            // find the width 
            int width = right - left;

            // find the min high of both lines
            int minHeight = Math.min(height[left] , height[right]);
            
            // calculate currect water
            int currentWater = minHeight * width;

            // update maxWater
            maxWater = Math.max(currentWater , maxWater);

            // iterate left or right according to which is min
            if(height[left] < height[right])
            {
                left++;
            }
            else
            {
                right--;
            }
 
        }
        return maxWater;
    }
}