class Solution {
    public void moveZeroes(int[] nums) {
        
        int i = 0;

        for(int j = 0; j < nums.length; j++)
        {
            // if j is non zero then swap with i 
            if(nums[j] != 0)
            {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                
                i++;
            }
        }
    }
}