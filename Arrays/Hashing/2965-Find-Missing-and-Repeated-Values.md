# Java \| HashSet + Sum \| O(n²) Time \| O(n²) Space

## Approach

We use a **HashSet** to detect the repeated number while traversing the
matrix. At the same time, we calculate the **actual sum** of all
elements.

The expected sum of numbers from **1 to n²** is:

``` text
Expected Sum = N × (N + 1) / 2
where N = n × n
```

Since one number is repeated and one number is missing:

``` text
Actual Sum = Expected Sum + Repeating - Missing
```

Therefore:

``` text
Missing = Expected Sum + Repeating - Actual Sum
```

## Algorithm

1.  Create a `HashSet`.
2.  Traverse every element in the grid.
3.  If the current number already exists in the set, store it as the
    repeating number.
4.  Otherwise, add it to the set.
5.  Compute the expected sum from `1` to `n²`.
6.  Calculate the missing number.
7.  Return `{repeating, missing}`.

## Java Solution

``` java
import java.util.HashSet;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        HashSet<Integer> set = new HashSet<>();

        int n = grid.length;
        int repeating = 0;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                actualSum += grid[i][j];

                if (set.contains(grid[i][j])) {
                    repeating = grid[i][j];
                } else {
                    set.add(grid[i][j]);
                }
            }
        }

        int expectedSum = (n * n) * (n * n + 1) / 2;
        int missing = expectedSum + repeating - actualSum;

        return new int[]{repeating, missing};
    }
}
```

## Complexity Analysis

-   **Time Complexity:** `O(n²)`
-   **Space Complexity:** `O(n²)`

## Key Takeaways

-   Uses a `HashSet` to detect the duplicate efficiently.
-   Computes the missing number using the sum formula.
-   Easy to understand and implement.
