class Solution {
    public int search(int[] nums, int target) {

        int st = 0;
        int end = nums.length - 1;

        while(st <= end)
        {
            // use this because interger value is verfow in worst case add int_max vakue to int_max 
            int mid = st + (end - st) / 2;

            if(nums[mid] == target)
            {
                return mid;
            }
            if(target > nums[mid])
            {
                st = mid + 1;
            }
            else
            {
                end = mid  - 1;
            }
        }
        return -1;
    }
}