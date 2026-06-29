# 42. Trapping Rain Water

## Intuition

The amount of water trapped at each index depends on the tallest bar on its left and the tallest bar on its right. Instead of finding these values repeatedly, we precompute them using two arrays.

## Approach

### Prefix & Suffix Arrays

1. Create two arrays:
   - `leftMax[]` to store the maximum height from the left.
   - `rightMax[]` to store the maximum height from the right.
2. Fill the `leftMax[]` array by traversing from left to right.
3. Fill the `rightMax[]` array by traversing from right to left.
4. Traverse the array again.
5. At each index, calculate the trapped water using:

   ```
   Water = min(leftMax[i], rightMax[i]) - height[i]
   ```

6. Add the trapped water to the total answer.
7. Return the total trapped water.

## Complexity

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

## Java Code

```java
// Solution is available in 42-Trapping-Rain-Water.java
```

Approach 1: Brute Force

Idea

For every index, find the maximum height on the left and the maximum height on the right. The water trapped at the current index is:

Water = min(leftMax, rightMax) - height[i]

Algorithm

1. Traverse every index.
2. Find the maximum height on the left.
3. Find the maximum height on the right.
4. Calculate trapped water.
5. Add it to the total water.

Complexity

Time  : O(n²)

Space : O(1)

------------------------------------------------------------

Approach 2: Prefix & Suffix Arrays (Better ⭐⭐)

Idea

Store the maximum height from the left and right in two arrays so that we don't calculate them repeatedly.

Water = min(leftMax[i], rightMax[i]) - height[i]

Algorithm

1. Create leftMax[].
2. Create rightMax[].
3. Fill leftMax[].
4. Fill rightMax[].
5. Traverse the array.
6. Calculate trapped water.
7. Return the total water.

Complexity

Time  : O(n)

Space : O(n)

------------------------------------------------------------

Approach 3: Two Pointers (Optimal ⭐⭐⭐)

Idea

Use two pointers and keep track of the maximum height seen from both sides. Move the pointer on the side with the smaller height and calculate trapped water without using extra arrays.

Algorithm

1. Initialize:
   left = 0
   right = n - 1
   leftMax = 0
   rightMax = 0
   water = 0

2. While left < right:
   - If height[left] < height[right]:
       • Update leftMax if needed.
       • Otherwise, add leftMax - height[left] to water.
       • Move left++.
   - Else:
       • Update rightMax if needed.
       • Otherwise, add rightMax - height[right] to water.
       • Move right--.

3. Return water.

Complexity

Time  : O(n)

Space : O(1)

------------------------------------------------------------

Formula

Water = min(leftMax, rightMax) - height[i]

Best Approach

✔ Brute Force      → O(n²), O(1)
✔ Prefix & Suffix  → O(n),  O(n)
✔ Two Pointers     → O(n),  O(1) ⭐⭐⭐