# 240. Search a 2D Matrix II

**Difficulty:** Medium  
**Topics:** Array, Binary Search, Divide and Conquer, Matrix

## Problem Statement

Write an efficient algorithm to search for a target value in an `m x n` integer matrix.

The matrix follows two properties:

1. Integers in each row are sorted in ascending order from left to right.
2. Integers in each column are sorted in ascending order from top to bottom.

Return `true` if the target exists in the matrix; otherwise, return `false`.

---

## Approach 1: Brute Force (Linear Search)

### Intuition

Traverse every element of the matrix and compare it with the target. If the target is found, return `true`. If the complete matrix is traversed without finding it, return `false`.

### Algorithm

1. Get the number of rows and columns.
2. Use nested loops to traverse the matrix.
3. Compare each element with the target.
4. If an element matches, return `true`.
5. Otherwise, return `false` after completing the traversal.

### Java Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
```

### Complexity Analysis

- **Time Complexity:** `O(m * n)` — In the worst case, every element is checked.
- **Space Complexity:** `O(1)` — No extra data structure is used.

---

## Approach 2: Binary Search on Each Row

### Intuition

Since every row is sorted in ascending order, we can apply binary search independently on each row.

If the target exists in any row, return `true`. Otherwise, continue searching the remaining rows.

### Algorithm

1. Get the number of rows and columns.
2. Iterate through each row.
3. Initialize `low = 0` and `high = n - 1`.
4. Apply binary search on the current row.
5. If the middle element equals the target, return `true`.
6. If the middle element is smaller, search the right half.
7. Otherwise, search the left half.
8. If no row contains the target, return `false`.

### Java Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {

            int low = 0;
            int high = n - 1;

            while (low <= high) {

                int mid = low + (high - low) / 2;

                if (matrix[i][mid] == target) {
                    return true;
                }
                else if (matrix[i][mid] < target) {
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}
```

### Complexity Analysis

- **Time Complexity:** `O(m * log n)` — Binary search takes `O(log n)` for each of the `m` rows.
- **Space Complexity:** `O(1)` — Only a few variables are used.

---

## Approach 3: Staircase Search (Optimal)

### Intuition

The matrix is sorted in both row-wise and column-wise directions.

Instead of searching every row independently, we can use both sorted properties to eliminate an entire row or column in each step.

Start from the **top-right corner** of the matrix.

There are three possible conditions:

1. If `current == target`, the target is found.
2. If `current > target`, move left because all elements below the current element are greater.
3. If `current < target`, move down because all elements to the left of the current element are smaller.

This process eliminates one row or one column at each step.

### Algorithm

1. Initialize `row = 0` and `col = n - 1`.
2. Start from the top-right element.
3. Continue while `row < m` and `col >= 0`.
4. Compare the current element with the target:
   - If equal, return `true`.
   - If greater, decrement `col`.
   - If smaller, increment `row`.
5. If the search boundaries are crossed, return `false`.

### Java Code

```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {

            int current = matrix[row][col];

            if (current == target) {
                return true;
            }
            else if (current > target) {
                col--;
            }
            else {
                row++;
            }
        }

        return false;
    }
}
```

### Complexity Analysis

- **Time Complexity:** `O(m + n)` — At most `m` downward movements and `n` leftward movements are possible.
- **Space Complexity:** `O(1)` — No extra space is required.

---

## Complexity Comparison

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| Brute Force | `O(m * n)` | `O(1)` |
| Binary Search on Each Row | `O(m * log n)` | `O(1)` |
| Staircase Search | `O(m + n)` | `O(1)` |

## Key Points

- Every row is sorted from left to right.
- Every column is sorted from top to bottom.
- Binary search can be applied independently to each row.
- Staircase Search uses both sorting properties together.
- Starting from the top-right corner allows us to eliminate one row or column in every step.
- Staircase Search is the optimal approach among these three for the general matrix dimensions.

**Recommended Approach:** Staircase Search — `O(m + n)` time and `O(1)` auxiliary space.