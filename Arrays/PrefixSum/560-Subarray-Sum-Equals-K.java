
class Solution {
    public int subarraySum(int[] nums, int k) {

        // Stores prefixSum as key and its frequency as value
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initially, an empty prefix sum (0) has occurred once
        // Helps to count subarrays starting from index 0
        map.put(0, 1);

        int count = 0;       // Total number of subarrays whose sum equals k
        int prefixSum = 0;   // Stores the current prefix sum

        for (int i = 0; i < nums.length; i++) {

            // Calculate the current prefix sum
            prefixSum = prefixSum + nums[i];

            // Find the required previous prefix sum
            int target = prefixSum - k;

            // If target exists, add its frequency to count
            // Frequency represents the number of valid subarrays
            if (map.containsKey(target)) {
                count += map.get(target);
            }

            // Store/update the frequency of the current prefix sum
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        // Return the total number of valid subarrays
        return count;
    }
}
