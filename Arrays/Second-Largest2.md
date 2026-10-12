# Second Largest Element — Approach 3 (One Traversal)

## Intuition

Instead of traversing the array twice or sorting it, we find the largest and second largest elements in a single traversal.

Whenever we find a new largest element, the previous largest becomes the second largest. Otherwise, if an element is smaller than the largest but greater than the second largest, we update the second largest.

## Approach

1\. Initialize `largest = -1` and `secondLargest = -1`.

2\. Traverse the array using a `for` loop.

3\. If `arr[i] > largest`:

- Update `secondLargest = largest`.
- Update `largest = arr[i]`.

4\. Otherwise, if `arr[i] < largest` and `arr[i] > secondLargest`, update `secondLargest = arr[i]`.

5\. Return `secondLargest`.

## Complexity

- **Time Complexity:** O(n), because the array is traversed only once.
- **Space Complexity:** O(1), because only two variables are used.

## Java Code

```java
class Solution {
    public int getSecondLargest(int[] arr) {

        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            }
            else if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}
```

**Example**

Input: `arr = [12, 35, 1, 10, 34, 1]`

- Read `12`: `largest = 12`, `secondLargest = -1`
- Read `35`: `largest = 35`, `secondLargest = 12`
- Read `1`: No update.
- Read `10`: No update.
- Read `34`: `secondLargest = 34`
- Read `1`: No update.

**Output:** `34`

**Note:** This implementation assumes positive integers. If negative values are allowed, initialize the variables differently or use a flag to track whether a value has been found.
