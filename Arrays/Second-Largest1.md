# Second Largest Element — Approach 2 (Two Traversals)

## Intuition

Instead of sorting the array, we find the largest element in the first traversal. Then, in the second traversal, we find the largest element that is smaller than the largest element.

## Approach

1\. Initialize `largest = -1`.

2\. Traverse the array and find the largest element.

3\. Initialize `secondLargest = -1`.

4\. Traverse the array again.

5\. If `arr[i] < largest` and `arr[i] > secondLargest`, update `secondLargest = arr[i]`.

6\. Return `secondLargest`. If no second largest element exists, return `-1`.

## Complexity

- **Time Complexity:** O(n), because the array is traversed twice.
- **Space Complexity:** O(1), because only two variables are used.

## Java Code

```java
class Solution {
    public int getSecondLargest(int[] arr) {

        int largest = -1;
        int secondLargest = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < largest && arr[i] > secondLargest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}
```

**Note:** This implementation assumes the array contains positive integers. The condition `arr[i] < largest` ensures that duplicate occurrences of the largest element are not considered the second largest.