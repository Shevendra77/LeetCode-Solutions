# 48. Rotate Image

**Difficulty:** Medium  
**Topics:** Array, Math, Matrix

## Problem Statement

You are given an `n x n` 2D `matrix` representing an image. Rotate the image by 90 degrees **clockwise**.

You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly. Do **not** allocate another 2D matrix to do the rotation.

**Example 1:**

```
Input:  matrix = [ [1, 2, 3],
                   [4, 5, 6],
                   [7, 8, 9] ]

Output:          [ [7, 4, 1],
                   [8, 5, 2],
                   [9, 6, 3] ]
```

**Example 2:**

```
Input:  matrix = [ [1, 2],
                   [3, 4] ]

Output:          [ [3, 1],
                   [4, 2] ]
```

---

## Approach: Transpose, Then Reverse Each Row (In-Place)

### Intuition

A 90 degree rotation is the combination of two flips:

- **Transpose** flips the matrix across its main diagonal.
- **Reverse each row** flips the matrix left to right.

The order of the two flips decides the direction of rotation:

| Order | Result |
|---|---|
| **Transpose, then reverse each row** | **Clockwise** |
| Reverse each row, then transpose | Anti-clockwise |

### Why it works (tracking the number `2`)

Take `[[1, 2], [3, 4]]`. The number `2` starts at the top-right corner. In a clockwise rotation it must move to the bottom-right.

| Step | `matrix` | Position of `2` |
|---|---|---|
| Start | `[[1, 2], [3, 4]]` | top-right |
| Transpose | `[[1, 3], [2, 4]]` | bottom-left |
| Reverse each row | `[[3, 1], [4, 2]]` | bottom-right |

The final matrix matches the expected output.

### Algorithm

1. Get the size `n` of the matrix.
2. Transpose the matrix in place: for each `i`, loop `j` from `i + 1` to `n - 1` and swap `matrix[i][j]` with `matrix[j][i]`.
3. For every row, reverse it using two pointers (`stCol` at the start, `endCol` at the end), swapping and moving the pointers inward.
4. The original matrix is now rotated clockwise.

### Java Code

```java
class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // 1. Transpose the matrix in place
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 2. Reverse each row using two pointers
        for (int row = 0; row < n; row++) {

            int stCol = 0, endCol = n - 1;

            while (stCol < endCol) {

                int tmp = matrix[row][stCol];
                matrix[row][stCol] = matrix[row][endCol];
                matrix[row][endCol] = tmp;

                stCol++;
                endCol--;
            }
        }
    }
}
```

### Dry Run

`matrix = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]`

**After step 1 (transpose):**

```
[1, 4, 7]
[2, 5, 8]
[3, 6, 9]
```

**After step 2 (reverse each row):**

```
[7, 4, 1]
[8, 5, 2]
[9, 6, 3]
```

This matches the expected output.

### Complexity Analysis

- **Time Complexity:** `O(n * n)` — The transpose visits about `n² / 2` pairs, and reversing rows visits every element once.
- **Space Complexity:** `O(1)` — Only the `tmp` variable and a few pointers are used.

---

## Common Mistakes

| Mistake | What goes wrong |
|---|---|
| Transpose loop with `j = 0` | Every pair is swapped twice, so the matrix stays unchanged. Use `j = i + 1`. |
| Not moving `stCol` and `endCol` | The `while` loop never ends (infinite loop). |
| Reverse rows first, then transpose | Gives an anti-clockwise rotation, not clockwise. |
| Creating a new matrix | Breaks the in-place requirement and uses `O(n * n)` space. |

## Related Problem

**GeeksforGeeks: Rotate by 90 degree (anti-clockwise)** is the same problem with the opposite direction. Reverse each row first, then transpose.

## Key Points

- Rotation by 90 degrees = transpose + one flip.
- Clockwise: transpose, then reverse each row.
- Anti-clockwise: reverse each row, then transpose.
- In the transpose, the inner loop starts from `i + 1` to avoid swapping pairs twice.
- Both steps work directly on the input matrix, so no extra matrix is created.

**Recommended Approach:** Transpose, then reverse each row — `O(n * n)` time and `O(1)` space.