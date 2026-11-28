import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // Store remainder as key and first index as value
        HashMap<Integer, Integer> map = new HashMap<>();

        // Handle subarrays starting from index 0
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Calculate current prefix sum
            prefixSum += nums[i];

            // Calculate remainder
            int rem = prefixSum % k;

            // Check whether the remainder already exists
            if (map.containsKey(rem)) {

                // Check subarray length is at least 2
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            }
            else {

                // Store only the first occurrence of remainder
                map.put(rem, i);
            }
        }

        return false;
    }
}