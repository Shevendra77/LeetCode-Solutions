
class Solution {

    // Approach 1: Counting Sort
    public void sortColorsCountingSort(int[] nums) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // Count 0s, 1s, and 2s
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int i = 0;

        // Place all 0s
        while (count0-- > 0) {
            nums[i++] = 0;
        }

        // Place all 1s
        while (count1-- > 0) {
            nums[i++] = 1;
        }

        // Place all 2s
        while (count2-- > 0) {
            nums[i++] = 2;
        }
    }


    // Approach 2: Dutch National Flag Algorithm
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            // Move 0s to the left
            if (nums[mid] == 0) {

                int tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;

                low++;
                mid++;
            }

            // 1s remain in the middle
            else if (nums[mid] == 1) {
                mid++;
            }

            // Move 2s to the right
            else {

                int tmp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = tmp;

                high--;
            }
        }
    }
}
