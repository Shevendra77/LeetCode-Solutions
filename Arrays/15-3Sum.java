import java.util.*;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        // Stores all unique triplets
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array to use the Two Pointer approach
        Arrays.sort(nums);

        // Fix one element at a time
        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    // Found a valid triplet
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values from the left
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate values from the right
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers
                    left++;
                    right--;
                }

                // Need a larger sum
                else if (sum < 0) {
                    left++;
                }

                // Need a smaller sum
                else {
                    right--;
                }
            }
        }

        return ans;
    }
}