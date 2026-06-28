/*
 * Problem: 53. Maximum Subarray
 * Difficulty: Medium
 *
 * Approach:
 * Kadane's Algorithm
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Either start a new subarray or continue the previous one
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            // Update the maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}