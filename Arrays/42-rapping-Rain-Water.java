class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int maxWater = 0;

        while(left <= right)
        {
            if(arr[left] <= arr[right])
            {
                if(arr[left] >= leftMax)
                {
                    leftMax = arr[left];
                }
                else
                {
                    maxWater += leftMax - arr[left];
                }
                left++;
            }
            else
            {
                if(arr[right] >= rightMax)
                {
                    rightMax = arr[right];
                }
                else
                {
                    maxWater += rightMax - arr[right];
                }
                right--;
             }
        }
        return maxWater;
    }
}