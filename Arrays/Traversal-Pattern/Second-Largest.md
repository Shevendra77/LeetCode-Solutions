# Second Largest Element — Approach 1 (Sorting)

## Intuition

We sort the array in ascending order. The largest element will be at the last index. Then, we traverse the array backward to find the first element that is different from the largest element.

## Approach

1\. Find the length of the array and store it in `n`.

2\. Sort the array using `Arrays.sort(arr)`.

3\. Initialize `largest = arr[n - 1]`.

4\. Traverse the array backward, starting from index `n - 2`.

5\. If `arr[i] != largest`, return `arr[i]` because it is the second largest distinct element.

6\. If no second largest element exists, return `-1`.

## Complexity

- **Time Complexity:** O(n log n), because sorting takes O(n log n) time.
- **Space Complexity:** O(log n) auxiliary space in typical Java primitive-array sorting implementations, due to the sorting implementation's stack usage.

## Java Code

```java
import java.util.Arrays;

class Solution {
    public int getSecondLargest(int[] arr) {

        int n = arr.length;

        Arrays.sort(arr);

        int largest = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                return arr[i];
            }
        }

        return -1;
    }
}
```

**Example**

Input: `arr = [12, 35, 1, 10, 34, 1]`

After sorting: `[1, 1, 10, 12, 34, 35]`

- Largest element = `35`
- The first element different from `35`, searching backward, is `34`.

Output: `34`

**Note:** This approach assumes the array contains at least one element. It modifies the original array by sorting it.