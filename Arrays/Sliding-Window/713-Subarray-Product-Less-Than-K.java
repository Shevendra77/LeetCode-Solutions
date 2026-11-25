
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1) {
            return 0;
        }

        int left = 0;
        int count = 0;
        int product = 1;

        for (int right = 0; right < nums.length; right++) {

            // 1. Expand the window
            product *= nums[right];

            // 2. Shrink the window if product >= k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // 3. Count valid subarrays ending at right
            count += right - left + 1;
        }

        return count;
    }
}
