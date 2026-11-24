# Trapping Rain Water

## Intuition

The amount of water trapped on top of any bar depends on the maximum height of bars to its left and right. Water can only be trapped up to the height of the shorter wall (`min(leftMax, rightMax)`).

Instead of computing `leftMax` and `rightMax` for every element using extra arrays, we can use a **two-pointer approach**. By moving pointers inward from both ends and comparing `height[left]` with `height[right]`, we can determine which side has the lower boundary wall and safely compute trapped water in a single pass with $O(1)$ extra space.

## Approach

1. Initialize two pointers:
   - `left = 0` (start of array)
   - `right = n - 1` (end of array)
2. Maintain variables `leftMax = 0`, `rightMax = 0`, and `water = 0`.
3. Loop while `left <= right`:
   - Compare `height[left]` and `height[right]`:
     - If `height[left] <= height[right]`:
       - If `height[left] >= leftMax`, update `leftMax = height[left]`.
       - Else, add `leftMax - height[left]` to `water`.
       - Increment `left`.
     - Else:
       - If `height[right] >= rightMax`, update `rightMax = height[right]`.
       - Else, add `rightMax - height[right]` to `water`.
       - Decrement `right`.
4. Return `water`.

## Complexity

- **Time Complexity:** $O(n)$ — Single pass using two pointers.
- **Space Complexity:** $O(1)$ — Only auxiliary variables are used.

## Java Code

```java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }
}
```