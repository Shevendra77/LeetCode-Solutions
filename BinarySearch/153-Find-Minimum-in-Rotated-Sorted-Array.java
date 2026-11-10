class Solution 
{
    public int findMin(int[] nums) 
     {
    
     int left = 0;
     int right = nums.length-1;

    // We are not searching for a target. We are narrowing the search range until the left and right pointer at same index therefor (<)

      while(left < right)
      {
        int mid = left + (right - left) / 2;

        //if right is sorted : (=) because mid can be answer : means clock-wise rotated
        if(nums[mid] < nums[right])
        {
           right = mid;
        }
        else
        {
            left = mid + 1;
        }
       }
      // when left and right as same point meet an so return either nums[left] or nums[right]
      return nums[left];
        
    }
}