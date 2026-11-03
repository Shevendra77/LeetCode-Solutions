# 54. Spiral Matrix

## Intuition

We need to traverse the matrix in spiral order, starting from the top-left corner and moving clockwise.

We use four boundaries to traverse the outer layer and gradually move towards the inner layers.

## Approach

**Layer-by-Layer Boundary Traversal (Four Pointers)**

## Algorithm

1. Initialize four boundaries:
   - `stRow = 0`
   - `endRow = m - 1`
   - `stCol = 0`
   - `endCol = n - 1`
2. Run a loop while `stRow <= endRow` and `stCol <= endCol`.
3. **Top Boundary:** Traverse from `stCol` to `endCol` and add elements. Keep the row fixed at `stRow`.
4. **Right Boundary:** Traverse from `stRow + 1` to `endRow` and add elements. Keep the column fixed at `endCol`.
5. **Bottom Boundary:** Traverse from `endCol - 1` to `stCol` in reverse order. If `stRow == endRow`, break to avoid duplicates.
6. **Left Boundary:** Traverse from `endRow - 1` to `stRow + 1` in reverse order. If `stCol == endCol`, break to avoid duplicates.
7. Shrink all four boundaries to move towards the next inner layer:
   - `stRow++`
   - `stCol++`
   - `endRow--`
   - `endCol--`
8. Return the result list.

## Boundary Indexing

| Boundary | Fixed Index | Changing Index | Correct Indexing |
|---|---|---|---|
| Top | `stRow` | `j` increases | `mat[stRow][j]` |
| Right | `endCol` | `i` increases | `mat[i][endCol]` |
| Bottom | `endRow` | `j` decreases | `mat[endRow][j]` |
| Left | `stCol` | `i` decreases | `mat[i][stCol]` |

## Complexity

- **Time Complexity:** `O(m × n)`
- **Auxiliary Space:** `O(1)` (excluding the output list)
- **Output Space:** `O(m × n)`

## Pattern

**Matrix + Four Boundaries + Layer-by-Layer Traversal**

## Java Code

```java
// Solution is available in 54-Spiral-Matrix.java
```