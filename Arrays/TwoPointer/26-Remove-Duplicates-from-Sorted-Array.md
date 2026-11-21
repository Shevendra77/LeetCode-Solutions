# 26. Remove Duplicates from Sorted Array

**Difficulty:** Easy

**Topic:** Array, Hashing, Two Pointers

## 🧠 Problem Understanding

Given a sorted integer array, remove duplicates in-place so that each unique element appears only once.

Return the number of unique elements (k).

The first k elements of the array must contain unique elements in sorted order.

## Approach 1: LinkedHashSet

1. Create a LinkedHashSet to store unique elements.
2. Traverse the array and insert all elements into the set.
3. LinkedHashSet automatically removes duplicates and maintains insertion order.
4. Copy unique elements back into the original array.
5. Return the count of unique elements.

### Java Code

```java
import java.util.*;

class Solution {
    public int removeDuplicates(int[] nums) {

        Set<Integer> st = new LinkedHashSet<>();

        for (int val : nums) {
            st.add(val);
        }

        int i = 0;

        for (int val : st) {
            nums[i++] = val;
        }

        return i;
    }
}
```

### Complexity Analysis

- Time Complexity: O(n)
- Space Complexity: O(n)

---

## Approach 2: Two Pointers (Optimal)

1. Initialize i = 0 to track the last unique element.
2. Traverse the array using j starting from index 1.
3. Compare nums[i] with nums[j].
4. If both elements are different:
   - Increment i.
   - Assign nums[i] = nums[j].
5. Return i + 1.

### Java Code

```java
class Solution {
    public int removeDuplicates(int[] nums) {

        int i = 0;

        for (int j = 1; j < nums.length; j++) {

            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
```

### Dry Run

**Input:**

`nums = [0,0,1,1,1,2,2,3,3,4]`

**Initial Values:**

`i = 0`

| j | nums[j] | Condition | i | Unique Elements |
|---|---|---|---|---|
| 1 | 0 | Duplicate | 0 | [0] |
| 2 | 1 | Different | 1 | [0,1] |
| 3 | 1 | Duplicate | 1 | [0,1] |
| 4 | 1 | Duplicate | 1 | [0,1] |
| 5 | 2 | Different | 2 | [0,1,2] |
| 6 | 2 | Duplicate | 2 | [0,1,2] |
| 7 | 3 | Different | 3 | [0,1,2,3] |
| 8 | 3 | Duplicate | 3 | [0,1,2,3] |
| 9 | 4 | Different | 4 | [0,1,2,3,4] |

**Final Output:**

`k = i + 1 = 5`

`Modified Array = [0,1,2,3,4,_,_,_,_,_]`

### Complexity Analysis

- Time Complexity: O(n)
- Space Complexity: O(1)

---

## Complexity Comparison

| Approach | Time | Space |
|---|---|---|
| LinkedHashSet | O(n) | O(n) |
| Two Pointers | O(n) | O(1) |

## Key Concepts

- LinkedHashSet
- Hashing
- Two Pointers
- In-place Array Modification
- Sorted Array

## Interview Note

The LinkedHashSet approach is useful for understanding Java Collections.

The Two Pointers approach is optimal because it modifies the original array using O(1) extra space.