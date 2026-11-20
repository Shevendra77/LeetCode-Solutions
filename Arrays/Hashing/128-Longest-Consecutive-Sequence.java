
import java.util.*;

class Solution {

    // Approach 1: Sorting
    // Time: O(N log N)
    // Space: O(log N) auxiliary

    public int longestConsecutiveSorting(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int count = 1;
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {

            // Ignore duplicate elements
            if (nums[i] == nums[i - 1]) {
                continue;
            }

            // Check consecutive elements
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else {
                count = 1;
            }

            longest = Math.max(count, longest);
        }

        return longest;
    }


    // Approach 2: HashSet (Optimal)
    // Time: O(N) average
    // Space: O(N)

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Add elements into HashSet
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        // Check each unique element
        for (int num : set) {

            // Find starting point
            if (!set.contains(num - 1)) {

                int count = 1;
                int current = num;

                // Count consecutive elements
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
