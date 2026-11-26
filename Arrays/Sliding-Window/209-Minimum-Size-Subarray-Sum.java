
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;

        // Expand the window by moving the right pointer
        for (int right = 0; right < nums.length; right++) {

            // Add the current element to the window sum
            sum += nums[right];

            // Shrink the window while the sum satisfies the target
            while (sum >= target) {

                // Calculate the current window length
                int currentLength = right - left + 1;

                // Update the minimum subarray length
                minLength = Math.min(minLength, currentLength);

                // Remove the leftmost element from the window
                sum -= nums[left];

                // Move the left pointer to shrink the window
                left++;
            }
        }

        // Return 0 if no valid subarray is found
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
