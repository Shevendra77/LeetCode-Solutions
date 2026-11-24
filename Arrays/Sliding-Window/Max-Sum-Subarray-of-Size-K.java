class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        
        int windowSum = 0;
        
        // calculate sum first window of size k
        for(int i = 0; i < k; i++)
        {
            windowSum += arr[i];
        }
        int maxSum = windowSum;
        
        // calculate sum next window by add one more no. and eliminate first no.
        for(int j = k ; j < arr.length; j++)
        {
            windowSum += arr[j];
            windowSum -= arr[j - k];
            
            // find the maxSum of windows
            
            maxSum = Math.max(maxSum , windowSum);
        }
        return maxSum;
    }
}