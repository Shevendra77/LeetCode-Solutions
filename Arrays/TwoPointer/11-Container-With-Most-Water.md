# 11. Container With Most Water

**Difficulty:** Medium

**Topic:** Array, Two Pointers, Greedy

## 🧠 Problem Understanding

You are given an integer array `height`, where each element represents the height of a vertical line.

Find two lines that together with the x-axis form a container that can store the maximum amount of water.

The water capacity depends on:

- Width: Distance between the two selected lines.
- Height: Minimum height of the two lines.

**Formula:**

`Area = min(height[left], height[right]) * (right - left)`

## Example 1

**Input:**

`height = [1,8,6,2,5,4,8,3,7]`

**Output:**

`49`

**Explanation:**

Choose the lines at index 1 and index 8.

- Minimum Height = min(8,7) = 7
- Width = 8 - 1 = 7
- Area = 7 * 7 = 49

## Approach 1: Brute Force

### Intuition

Check every possible pair of lines and calculate the water capacity.

Update the maximum area whenever a larger area is found.

### Steps

1. Use two nested loops.
2. Select every possible pair of lines.
3. Calculate the width.
4. Find the minimum height.
5. Calculate the area.
6. Update the maximum water capacity.

### Java Code

```java
class Solution {
    public int maxArea(int[] height) {

        int maxWater = 0;

        for (int i = 0; i < height.length; i++) {

            for (int j = i + 1; j < height.length; j++) {

                int width = j - i;

                int minHeight = Math.min(height[i], height[j]);

                int currentWater = minHeight * width;

                maxWater = Math.max(currentWater, maxWater);
            }
        }

        return maxWater;
    }
}
```

### Complexity Analysis

- Time Complexity: O(n²)
- Space Complexity: O(1)

---

## Approach 2: Two Pointers (Optimal)

### Intuition

Instead of checking every possible pair, use two pointers to find the maximum water capacity.

- `left`: Starts from index 0.
- `right`: Starts from the last index.

Move the pointer with the smaller height because the shorter line limits the water capacity.

### Steps

1. Initialize `left = 0`.
2. Initialize `right = height.length - 1`.
3. Initialize `maxWater = 0`.
4. Calculate the width using `right - left`.
5. Find the minimum height using `Math.min()`.
6. Calculate the current water capacity.
7. Update `maxWater`.
8. Move the pointer with the smaller height.
9. Repeat until `left < right` is no longer true.
10. Return `maxWater`.

### Java Code

```java
class Solution {
    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {

            // Find the width
            int width = right - left;

            // Find the minimum height of both lines
            int minHeight = Math.min(height[left], height[right]);

            // Calculate current water
            int currentWater = minHeight * width;

            // Update maxWater
            maxWater = Math.max(currentWater, maxWater);

            // Move the pointer with smaller height
            if (height[left] < height[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        return maxWater;
    }
}
```

### Dry Run

**Input:**

`height = [1,8,6,2,5,4,8,3,7]`

**Initial Values:**

`left = 0`, `right = 8`, `maxWater = 0`

| Left | Right | Min Height | Width | Current Water | Max Water |
|---|---|---|---|---|---|
| 0 | 8 | 1 | 8 | 8 | 8 |
| 1 | 8 | 7 | 7 | 49 | 49 |
| 1 | 7 | 3 | 6 | 18 | 49 |
| 1 | 6 | 8 | 5 | 40 | 49 |
| 1 | 5 | 4 | 4 | 16 | 49 |
| 1 | 4 | 5 | 3 | 15 | 49 |
| 1 | 3 | 2 | 2 | 4 | 49 |
| 1 | 2 | 6 | 1 | 6 | 49 |

When both heights are equal (row 4: 8 and 8), the `else` branch runs, so `right` moves.

**Final Output:**

`49`

### Complexity Analysis

- Time Complexity: O(n) – Each pointer moves through the array at most once.
- Space Complexity: O(1) – No extra data structure is used.

---

## Complexity Comparison

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | O(n²) | O(1) |
| Two Pointers | O(n) | O(1) |

## Key Concepts

- Array
- Two Pointers
- Greedy Algorithm
- Maximum Area
- Space Optimization

## Interview Note

**Why do we move the smaller-height pointer?**

The area is calculated using:

`Area = Width * Minimum Height`

The shorter line limits the water capacity.

If we move the taller pointer, the width decreases while the limiting height cannot increase.

Therefore, moving the shorter pointer gives us a chance to find a taller line and potentially increase the area.

**Recommended Approach: Two Pointers (O(n) Time, O(1) Space).**