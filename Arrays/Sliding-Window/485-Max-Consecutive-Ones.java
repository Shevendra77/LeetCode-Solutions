class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int count = 0;
        int maxCount = 0;

        for(int val : nums)
        {
            // if we get 1 so increased count and update maxCount
            if(val == 1)
            {
                count++;
                maxCount = Math.max(count , maxCount);
            }
            // if we get 0 so reinitilized with 0
            else
            {
                count = 0;
            }
        }
        return maxCount;
    }
}