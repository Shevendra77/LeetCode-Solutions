import java.util.Arrays;
import java.util.HashMap;

public class MajorityElementAllApproaches {

    // Approach 1: Brute Force
    // Time: O(n^2), Space: O(1)
    public static int majorityElementBruteForce(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return nums[i];
            }
        }

        return -1;
    }

    // Approach 2: Sorting
    // Time: O(n log n)
    public static int majorityElementSorting(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // Approach 3: HashMap
    // Time: O(n) average, Space: O(n)
    public static int majorityElementHashMap(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            int frequency = map.getOrDefault(num, 0) + 1;
            map.put(num, frequency);

            if (frequency > n / 2) {
                return num;
            }
        }

        return -1;
    }

    // Approach 4: Boyer-Moore Voting Algorithm
    // Time: O(n), Space: O(1)
    public static int majorityElementBoyerMoore(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }

            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println("Brute Force: "
                + majorityElementBruteForce(nums.clone()));

        System.out.println("Sorting: "
                + majorityElementSorting(nums.clone()));

        System.out.println("HashMap: "
                + majorityElementHashMap(nums.clone()));

        System.out.println("Boyer-Moore: "
                + majorityElementBoyerMoore(nums.clone()));
    }
}

