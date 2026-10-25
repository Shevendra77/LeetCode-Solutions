# LeetCode 349 — Intersection of Two Arrays

**Difficulty:** Easy

## Approach

**HashSet**

## Intuition

Use a `HashSet` to store elements of `nums1`. Traverse `nums2` and check which elements exist in the first set. Use another `HashSet` to ensure the result contains only unique elements.

## Algorithm

1. Create a `HashSet` named `set`.
2. Add all elements of `nums1` to `set`.
3. Create another `HashSet` named `result`.
4. Traverse `nums2`.
5. If an element exists in `set`, add it to `result`.
6. Convert `result` into an integer array and return it.

## Java Code

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }

        int[] ans = new int[result.size()];
        int i = 0;

        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }
}
```

## Dry Run

**Input:**

```
nums1 = [1, 2, 2, 1]
nums2 = [2, 2]
```

**Step 1:** Store `nums1` in a HashSet.

```
set = [1, 2]
```

**Step 2:** Traverse `nums2`.

* First `2`: exists in `set`, so add it to `result`.
* Second `2`: exists in `set`, but `result` already contains `2`.

```
result = [2]
```

**Output:** `[2]`

## Complexity Analysis

* **Time:** `O(n + m)` average
* **Space:** `O(n + m)`

Here, `n` and `m` are the lengths of `nums1` and `nums2`.

## Pattern

**Array + HashSet + Duplicate Removal**

## Interview Note

HashSet provides average `O(1)` insertion and lookup. The second HashSet ensures that each common element appears only once in the answer.