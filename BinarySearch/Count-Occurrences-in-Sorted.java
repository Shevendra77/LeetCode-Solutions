class Solution 
{
    int countFreq(int[] nums, int target) 
    {
        int first = firstPosition(nums, target);
        int last =  lastPosition(nums, target);
        
        if(first == -1)
        {
            return 0;
        }
        return last - first + 1;
    }
    
    // Search first occurence
            public int firstPosition(int nums[] , int target)
            {
                int low = 0 , high = nums.length - 1;
                int ans = -1;

                while(low <= high)
                {
                    int mid = low + (high - low) / 2;
                    if(nums[mid] == target)
                    {
                        ans = mid;
                        high = mid - 1;
                    }
                    else if(nums[mid] > target)
                    {
                        high = mid -1;
                    }
                    else
                    {
                        low = mid + 1;
                    }
                }
                return ans;
            }

              // Search last occurence
            public int lastPosition(int nums[] , int target)
            {
                int low = 0 , high = nums.length - 1;
                int ans = -1;

                while(low <= high)
                {
                    int mid = low + (high - low) / 2;
                    if(nums[mid] == target)
                    {
                        ans = mid;
                        low = mid + 1;
                    }
                    else if(nums[mid] < target)
                    {
                        low = mid + 1;
                    }
                    else
                    {
                        high = mid - 1;
                    }
                }
                return ans;
            }
}
