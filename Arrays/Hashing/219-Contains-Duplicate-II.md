# 219. Contains Duplicate II

### 🧠 Intuition

We need to check whether the same number appears again within a distance of `k` indexes.

For this, we use a **HashMap** to store each number and its last seen index.

- Key = Array element
- Value = Index of that element

If the number already exists in the map, calculate the distance between its current index and its previously stored index.

### 🔍 Approach: HashMap – Last Seen Index

1. Create a HashMap to store elements and their indexes.
2. Traverse the array using a `for` loop.
3. Check whether the current element already exists using `map.containsKey(nums[i])`.
4. If it exists, calculate the distance:

   `i - map.get(nums[i])`

5. If the distance is less than or equal to `k`, return `true`.
6. Otherwise, update the element's index to the current index.
7. If no nearby duplicate is found, return `false`.

### 💻 Java Code

```java
class Solution 
{
    public boolean containsNearbyDuplicate(int[] nums, int k) 
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++)
        {  
            // Check whether the element exists in the map
            if (map.containsKey(nums[i]))
            {
                // If it exists, calculate the distance
                if (i - map.get(nums[i]) <= k)
                {
                    return true;
                }
            }

            // Update the index to the current index
            map.put(nums[i], i);
        }

        return false;
    }
}
```

### 📊 Dry Run

**Input:**
```java
nums = [1, 2, 3, 1]
k = 3
```

| Index (i) | Element | Previous Index | Distance | Action |
|---:|---:|---:|---:|---|
| 0 | 1 | Not found | — | Store 1 → 0 |
| 1 | 2 | Not found | — | Store 2 → 1 |
| 2 | 3 | Not found | — | Store 3 → 2 |
| 3 | 1 | 0 | 3 - 0 = 3 | Return `true` |

**Output:** `true`

### ⏱️ Complexity Analysis

- **Time Complexity:** `O(N)` – We traverse the array once. HashMap operations take O(1) average time.
- **Space Complexity:** `O(N)` – In the worst case, the HashMap stores all array elements.

### ⭐ Important Points

- `map.containsKey(nums[i])` checks whether the element already exists.
- `map.get(nums[i])` retrieves its previously stored index.
- `map.put(nums[i], i)` updates the element with its latest index.
- We do not need `Math.abs()` because we traverse from left to right, so the current index is always greater than the previous index.

**Pattern:** Hashing → HashMap → Last Seen Index