# 217. Contains Duplicate

### 🧠 Intuition

We need to check whether any number appears **more than once** in the array.

For this, we use a **HashSet**, which stores only unique elements and lets us check "seen before?" in O(1) average time.

- If the number is already in the set → duplicate found
- Otherwise → add it to the set and continue

### 🔍 Approach: HashSet – Seen Before

1. Create a HashSet to store the elements we have seen.
2. Traverse the array using a `for-each` loop.
3. Check whether the current element already exists using `set.contains(num)`.
4. If it exists, return `true`.
5. Otherwise, add the element to the set using `set.add(num)`.
6. If the loop finishes without finding a repeat, return `false`.

### 💻 Java Code

```java
package Hashing;
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
```

### 📊 Dry Run

**Input:**
```java
nums = [1, 2, 3, 1]
```

| Step | Element | In Set? | Action | Set After |
|---:|---:|---|---|---|
| 1 | 1 | No | Add 1 | {1} |
| 2 | 2 | No | Add 2 | {1, 2} |
| 3 | 3 | No | Add 3 | {1, 2, 3} |
| 4 | 1 | Yes | Return `true` | — |

**Output:** `true`

**Input (no duplicate):**
```java
nums = [1, 2, 3, 4]
```

Every element is new, so each one is added to the set. The loop ends and the method returns `false`.

### ⏱️ Complexity Analysis

- **Time Complexity:** `O(N)` – We traverse the array once. HashSet operations take O(1) average time.
- **Space Complexity:** `O(N)` – In the worst case, the HashSet stores all array elements.

### ⭐ Important Points

- `set.contains(num)` checks whether the element was seen before.
- `set.add(num)` stores the element for future checks.
- A HashSet is enough here because we only need to know **if** a value exists, not its index or count.
- Alternative: `set.add(num)` returns `false` if the element already exists, so the check can be shortened to `if (!set.add(num)) return true;`.
- Another approach is sorting and comparing neighbours, which uses `O(N log N)` time but `O(1)` extra space.

**Pattern:** Hashing → HashSet → Seen Before