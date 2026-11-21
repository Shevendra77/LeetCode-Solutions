import java.util.*;

class Solution {

    // Approach 1: LinkedHashSet
    public int removeDuplicates1(int[] nums) {

        Set<Integer> st = new LinkedHashSet<>();

        for (int val : nums) {
            st.add(val);
        }

        int i = 0;

        for (int val : st) {
            nums[i++] = val;
        }

        return i;
    }

    // Approach 2: Two Pointers (Optimal)
    public int removeDuplicates2(int[] nums) {

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}