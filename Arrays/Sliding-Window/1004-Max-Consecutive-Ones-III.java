class Solution {
    public int longestOnes(int[] nums, int k) {

       int left = 0;       // Starting index of the window
       int maxLen = 0;     // Maximum valid window length
       int countZero = 0;  // Number of zeros in the current window

    for (int right = 0; right < nums.length; right++) {

    // Count zeros entering the window
    if (nums[right] == 0) {
        countZero++;
    }

    // Shrink the window if zeros exceed k
    while (countZero > k) {

        if (nums[left] == 0) {
            countZero--;
        }

        left++;
    }

    // Update maximum valid window length
    maxLen = Math.max(maxLen, right - left + 1);
}
        return maxLen;
    }
}