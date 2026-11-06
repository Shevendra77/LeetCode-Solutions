# Transpose of Matrix

**Difficulty:** Easy  
**Topics:** Array, Matrix

## Problem Statement

Given a square matrix `mat[][]` of size `n x n`, find its transpose.

The transpose of a matrix is obtained by converting its rows into columns and its columns into rows. In other words, the element at position `(i, j)` in the result is the element at position `(j, i)` in the original matrix.

**Example:**

```
Input:  mat = [ [1, 2, 3],
                [4, 5, 6],
                [7, 8, 9] ]

Output:       [ [1, 4, 7],
                [2, 5, 8],
                [3, 6, 9] ]
```

---

## Approach 1: Build a New ArrayList Matrix

### Intuition

Column `i` of the original matrix becomes row `i` of the transposed matrix. So for every `i`, walk down column `i` using `mat[j][i]` and collect the values into a new row.

### Algorithm

1. Get the size `n` of the matrix.
2. Create an empty `ArrayList<ArrayList<Integer>>` called `tMat`.
3. For each `i` from `0` to `n - 1`, create a new empty `row`.
4. For each `j` from `0` to `n - 1`, add `mat[j][i]` to `row`.
5. After the inner loop, add `row` to `tMat`.
6. Return `tMat`.

### Java Code

```java
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {

        int n = mat.length;
        ArrayList<ArrayList<Integer>> tMat = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(mat[j][i]);
            }

            tMat.add(row);
        }

        return tMat;
    }
}
```

### Complexity Analysis

- **Time Complexity:** `O(n * n)` — Every element is visited once.
- **Space Complexity:** `O(n * n)` — A new `n x n` matrix is created for the result.

---

## Approach 2: Build a New 2D Array

### Intuition

A plain `int[][]` already has all its slots after `new int[n][n]`, so we can assign values directly with `tMat[i][j] = mat[j][i]` without creating rows first.

### Algorithm

1. Get the size `n` of the matrix.
2. Create a new array `tMat` of size `n x n`.
3. For each `i` and `j`, assign `tMat[i][j] = mat[j][i]`.
4. Return `tMat`.

### Java Code

```java
class Solution {
    public int[][] transpose(int[][] mat) {

        int n = mat.length;
        int[][] tMat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tMat[i][j] = mat[j][i];
            }
        }

        return tMat;
    }
}
```

> **Note:** The return type must be `int[][]`. It will not compile if the method signature returns `ArrayList<ArrayList<Integer>>`.

### Complexity Analysis

- **Time Complexity:** `O(n * n)` — Every element is visited once.
- **Space Complexity:** `O(n * n)` — A new `n x n` array is created.

---

## Approach 3: In-Place Swap (Optimal Space)

### Intuition

For a square matrix, transposing means swapping each element above the diagonal with its mirror element below the diagonal. The diagonal elements stay where they are.

The inner loop must start from `j = i + 1`. If it started from `0`, every pair would be swapped twice and the second swap would undo the first.

### Algorithm

1. Get the size `n` of the matrix.
2. For each `i` from `0` to `n - 1`, loop `j` from `i + 1` to `n - 1`.
3. Swap `mat[i][j]` with `mat[j][i]` using a temporary variable.
4. The original matrix is now transposed.

### Java Code

```java
class Solution {
    public void transpose(int[][] mat) {

        int n = mat.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
    }
}
```

> **Note:** This modifies the original matrix and returns `void`. It only works for square matrices.

### Complexity Analysis

- **Time Complexity:** `O(n * n)` — About `n² / 2` swaps are performed.
- **Space Complexity:** `O(1)` — Only the `tmp` variable is used.

---

## Complexity Comparison

| Approach | Time Complexity | Space Complexity |
|---|---|---|
| New ArrayList Matrix | `O(n * n)` | `O(n * n)` |
| New 2D Array | `O(n * n)` | `O(n * n)` |
| In-Place Swap | `O(n * n)` | `O(1)` |

## Key Points

- The element at `(i, j)` in the result comes from `(j, i)` in the original matrix.
- Every approach needs `O(n * n)` time because every element must be visited.
- Creating a new matrix costs `O(n * n)` extra space, even if it is an `ArrayList`.
- The in-place swap uses `O(1)` extra space, but changes the input matrix.
- In the in-place swap, the inner loop starts from `i + 1` to avoid swapping pairs twice.
- If the method must return `ArrayList<ArrayList<Integer>>`, a new list has to be built, so space is `O(n * n)`.
- For a non-square matrix, use `rows = mat.length` and `cols = mat[0].length`, and create a result of size `cols x rows`. In-place swapping does not work there.

**Recommended Approach:** In-Place Swap — `O(n * n)` time and `O(1)` auxiliary space (when modifying the input is allowed). Use the New ArrayList approach when the required return type is `ArrayList<ArrayList<Integer>>`.