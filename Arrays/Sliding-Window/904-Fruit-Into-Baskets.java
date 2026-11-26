
class Solution {
    public int totalFruit(int[] fruits) {

        int ans = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Expand the window using the right pointer
        for (int right = 0; right < fruits.length; right++) {

            // Add the current fruit and update its frequency
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // Shrink the window if more than two fruit types exist
            while (map.size() > 2) {

                // Decrease the frequency of the leftmost fruit
                map.put(fruits[left], map.get(fruits[left]) - 1);

                // Remove the fruit when its frequency becomes zero
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                // Move the left pointer forward
                left++;
            }

            // Update the maximum window length
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}
