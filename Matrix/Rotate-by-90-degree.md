# Rotate by 90 Degree (Anti-Clockwise)

**Difficulty:** Medium  
**Topics:** Array, Matrix

## Problem Statement

Given a square matrix `mat[][]`, rotate it by 90 degrees in the **anti-clockwise** direction **without using any extra space**.

**Example 1:**

```
Input:  mat = [ [0, 1, 2],
                [3, 4, 5],
                [6, 7, 8] ]

Output:       [ [2, 5, 8],
                [1, 4, 7],
                [0, 3, 6] ]
```

**Example 2:**

```
Input:  mat = [ [1, 2],
                [3, 4] ]

Output:       [ [2, 4],
                [1, 3] ]
```

---

## Approach: Reverse Each Row, Then Transpose (In-Place)

### Intuition

A 90 degree rotation is the combination of two flips:

- **Reverse each row** flips the matrix left to right.
- **Transpose** flips the matrix across its main diagonal.

The order of the two flips decides the direction of rotation:

| Order | Result |
|---|---|
| Transpose, then reverse each row | Clockwise |
| **Reverse each row, then transpose** | **Anti-clockwise** |

### Why the order matters (tracking the number `2`)

Take `[[1, 2], [3, 4]]`. The number `2` starts at the top-right corner. In an anti-clockwise rotation it must move to the top-left.

| Step | `mat` | Position of `2` |
|---|---|---|
| Start | `[[1, 2], [3, 4]]` | top-right |
| Reverse each row | `[[2, 1], [4, 3]]` | top-left |
| Transpose | `[[2, 4], [1, 3]]` | top-left |

The final matrix matches the expected output.

### Algorithm

1. Get the size `n` of the matrix.
2. For every row, reverse it using two pointers (`stCol` at the start, `endCol` at the end), swapping and moving the pointers inward.
3. Transpose the matrix in place: for each `i`, loop `j` from `i + 1` to `n - 1` and swap `mat[i][j]` with `mat[j][i]`.
4. The original matrix is now rotated anti-clockwise.

### Java Code

```java
class Solution {
    public void rotateMatrix(int[][] mat) {

        int n = mat.length;

        // 1. Reverse each row of the matrix using two pointers
        for (int row = 0; row < n; row++) {

            int stCol = 0, endCol = n - 1;

            while (stCol <= endCol) {

                int tmp = mat[row][stCol];
                mat[row][stCol] = mat[row][endCol];
                mat[row][endCol] = tmp;

                stCol++;
                endCol--;
            }
        }

        // 2. Transpose the matrix in place
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

### Dry Run

`mat = [[0, 1, 2], [3, 4, 5], [6, 7, 8]]`

**After step 1 (reverse each row):**

```
[2, 1, 0]
[5, 4, 3]
[8, 7, 6]
```

**After step 2 (transpose):**

```
[2, 5, 8]
[1, 4, 7]
[0, 3, 6]
```

This matches the expected output.

### Complexity Analysis

- **Time Complexity:** `O(n * n)` — Reversing rows visits every element once, and the transpose visits about `n² / 2` pairs.
- **Space Complexity:** `O(1)` — Only the `tmp` variable and a few pointers are used.

---

## Common Mistakes

| Mistake | What goes wrong |
|---|---|
| Transpose loop with `j = 0` | Every pair is swapped twice, so the matrix stays unchanged. Use `j = i + 1`. |
| Not moving `stCol` and `endCol` | The `while` loop never ends (infinite loop). |
| Transpose first, then reverse rows | Gives a clockwise rotation, not anti-clockwise. |

## Alternative Approach: Transpose, Then Reverse Each Column

Transposing first and then reversing each **column** (swapping top and bottom in every column) also gives an anti-clockwise rotation, with the same complexity.

## Key Points

- Rotation by 90 degrees = transpose + one flip.
- Anti-clockwise: reverse each row, then transpose.
- Clockwise: transpose, then reverse each row.
- In the transpose, the inner loop starts from `i + 1` to avoid swapping pairs twice.
- Both steps work directly on the input matrix, so no extra matrix is created.

**Recommended Approach:** Reverse each row, then transpose — `O(n * n)` time and `O(1)` space.