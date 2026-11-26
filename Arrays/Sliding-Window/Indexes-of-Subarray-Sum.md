# Indexes of Subarray Sum

## Intuition

We use the Sliding Window technique to find a continuous subarray whose sum equals the target.

We expand the window by adding elements. If the sum becomes greater than the target, we shrink the window by removing elements from the beginning.

## Approach

1. Initialize three variables:
   - `start = 0`
   - `end = 0`
   - `sum = 0`
2. Create an empty `ArrayList` to store the starting and ending indices.
3. Traverse the array using a `for` loop and add `arr[i]` to `sum`.
4. If `sum >= target`, update `end = i`.
5. While `sum > target`, subtract `arr[start]` from `sum` and increment `start`.
6. If `sum == target`, add `start + 1` and `end + 1` to the list and return it.
7. If no matching subarray is found, add `-1` to the list and return it.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1), excluding the returned list.

## Java Code

```java
import java.util.*;

class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {

        int start = 0, end = 0, sum = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum >= target) {
                end = i;

                while (sum > target && start <= i) {
                    sum -= arr[start];
                    start++;
                }
            }

            if (sum == target) {
                list.add(start + 1);
                list.add(end + 1);
                return list;
            }
        }

        list.add(-1);
        return list;
    }
}
```

**Note:** This Sliding Window approach assumes the array contains non-negative integers.