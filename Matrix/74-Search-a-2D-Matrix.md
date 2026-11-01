# Search in Sorted Matrix

**Difficulty:** Medium

## Problem Statement

Given a strictly sorted 2D matrix `mat[][]` of size `n × m` and a number `x`, find whether `x` is present in the matrix or not.

---

# Approach 1: Binary Search on Rows + Binary Search in a Specific Row

## Intuition

Since every row is sorted and the first element of each row is greater than the last element of the previous row, we can use two separate binary searches.

1. First, find the correct row where the target can exist.
2. Then, apply binary search inside that selected row.

## Algorithm

1. Calculate the number of rows and columns.
2. Initialize `startRow = 0` and `endRow = m - 1`.
3. Apply binary search to find the correct row.
4. Calculate `midRow`.
5. Check whether the target lies between the first and last elements of that row.
6. If the correct row is found, call `searchInRow(mat, target, midRow)`.
7. Apply binary search inside the selected row.
8. Return `true` if the target is found; otherwise, return `false`.

## Java Code

```java
class Solution {

    public boolean searchInRow(int[][] mat, int target, int row) {

        int n = mat[0].length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (mat[row][mid] == target) {
                return true;
            }
            else if (mat[row][mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int startRow = 0;
        int endRow = m - 1;

        while (startRow <= endRow) {

            int midRow = startRow + (endRow - startRow) / 2;

            if (target >= mat[midRow][0] &&
                target <= mat[midRow][n - 1]) {

                return searchInRow(mat, target, midRow);
            }
            else if (target > mat[midRow][n - 1]) {
                startRow = midRow + 1;
            }
            else {
                endRow = midRow - 1;
            }
        }

        return false;
    }
}
```

## Complexity Analysis

- **Time Complexity:** `O(log m + log n)`
- **Auxiliary Space:** `O(1)`

---

# Approach 2: Binary Search on the Entire Matrix

## Intuition

Since every row is sorted and the first element of each row is greater than the last element of the previous row, the entire matrix can be treated as a single sorted 1D array.

We don't actually create a new array. Instead, we use index mapping to access elements directly from the 2D matrix.

## Approach

1. Apply binary search on the virtual 1D index range.
2. Calculate the middle index.
3. Convert the 1D index into 2D coordinates.
4. Compare the matrix element with the target.
5. Adjust the search range accordingly.

**Index Mapping:**

```java
int row = mid / n;
int col = mid % n;
```

Here, `n` represents the number of columns.

## Algorithm

1. Calculate the number of rows `m` and columns `n`.
2. Initialize `low = 0` and `high = m * n - 1`.
3. Run binary search while `low <= high`.
4. Calculate the middle index.
5. Find the row using `mid / n`.
6. Find the column using `mid % n`.
7. If the current element equals the target, return `true`.
8. If the current element is smaller than the target, search the right half.
9. Otherwise, search the left half.
10. If the loop finishes, return `false`.

## Java Code

```java
class Solution {

    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Convert 1D index into 2D coordinates
            int row = mid / n;
            int col = mid % n;

            if (mat[row][col] == target) {
                return true;
            }
            else if (mat[row][col] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}
```

## Complexity Analysis

- **Time Complexity:** `O(log(m * n))`
- **Auxiliary Space:** `O(1)`

---

# Comparison of Both Approaches

| Feature | Approach 1 | Approach 2 |
|---|---|---|
| Technique | Two Binary Searches | One Binary Search |
| Row selection | Separate binary search | Index mapping |
| Element search | Separate binary search | Same binary search |
| Time Complexity | O(log m + log n) | O(log(m × n)) |
| Space Complexity | O(1) | O(1) |

## Key Points

- Approach 1 uses two separate binary searches: one for finding the row and another for searching inside that row.
- Approach 2 treats the entire matrix as a virtual sorted 1D array.
- Both approaches have the same asymptotic time complexity.
- Approach 2 is more compact and avoids a separate row-search operation.