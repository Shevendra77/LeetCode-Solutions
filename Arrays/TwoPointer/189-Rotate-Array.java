class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

 // id k value is greater then nums.length 
//Since the array has only 5 elements, rotating it 5 times brings it back to its original position.

         k = k % n;

// Reverse the entire array.
        reverse(nums , 0 , n-1);

// Reverse the first k elements.
        reverse(nums , 0 , k-1);

// Reverse the remaining elements.
        reverse(nums, k , n-1);

    }
         private void reverse(int nums[] , int left , int right)
         {
            while(left < right)
            {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
         }
        
    
}