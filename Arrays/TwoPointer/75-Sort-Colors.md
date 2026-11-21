# 75. Sort Colors

## Intuition

The array contains only three distinct values: `0`, `1`, and `2`.

Instead of sorting the array, we can divide it into three regions using the **Dutch National Flag Algorithm**:

- Left side → `0`s
- Middle → `1`s
- Right side → `2`s

Using three pointers, we can sort the array in a single traversal without using any extra space.

## Approach

1. Initialize three pointers:
# 75. Sort Colors

**Difficulty:** Medium

**Topic:** Array, Two Pointers, Sorting, Dutch National Flag Algorithm

## 🧠 Problem Understanding

Given an array `nums` containing only three types of elements: `0`, `1`, and `2`, sort the array in-place.

- `0` represents Red.
- `1` represents White.
- `2` represents Blue.

The final array should contain all 0s first, followed by all 1s, and then all 2s.

**Example:**

Input:
```text
nums = [2,0,2,1,1,0]
```

Output:
```text
[0,0,1,1,2,2]
```

## Approach 1: Counting Sort

### 💡 Intuition

Instead of directly sorting the array, count how many times 0, 1, and 2 appear.

Then overwrite the original array:
1. Place all 0s first.
2. Place all 1s next.
3. Place all 2s at the end.

### Java Code

```java
class Solution {
    public void sortColors(int[] nums) {

        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        // Count occurrences of 0, 1, and 2
        for (int num : nums) {
            if (num == 0) {
                count0++;
            } else if (num == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        int i = 0;

        // Place all 0s
        while (count0-- > 0) {
            nums[i++] = 0;
        }

        // Place all 1s
        while (count1-- > 0) {
            nums[i++] = 1;
        }

        // Place all 2s
        while (count2-- > 0) {
            nums[i++] = 2;
        }
    }
}
```

### Complexity Analysis

- **Time Complexity:** O(n) – One traversal to count and another to overwrite the array.
- **Space Complexity:** O(1) – Only three counter variables are used.

---

## Approach 2: Dutch National Flag Algorithm (Three Pointers)

### 💡 Intuition

Use three pointers: `low`, `mid`, and `high` to sort the array in a single traversal.

- `low`: Position for the next 0.
- `mid`: Current element being checked.
- `high`: Position for the next 2.

### Three Pointer Conditions

1. If `nums[mid] == 0`:
   - Swap `nums[low]` and `nums[mid]`.
   - Increment `low` and `mid`.

2. If `nums[mid] == 1`:
   - Increment `mid` because 1 belongs in the middle.

3. If `nums[mid] == 2`:
   - Swap `nums[mid]` and `nums[high]`.
   - Decrement `high`.
   - Do not increment `mid` because the swapped element needs to be checked.

### Java Code

```java
class Solution {
    public void sortColors(int[] nums) {

        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {

            // Move all 0s to the left
            if (nums[mid] == 0) {

                int tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;

                low++;
                mid++;
            }

            // Skip 1s because they belong in the middle
            else if (nums[mid] == 1) {
                mid++;
            }

            // Move all 2s to the right
            else {

                int tmp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = tmp;

                high--;
            }
        }
    }
}
```

### Dry Run

**Input:**
```text
nums = [2,0,2,1,1,0]
```

Initial values:
```text
low = 0
mid = 0
high = 5
```

| Step | nums[mid] | Operation | Array | low | mid | high |
|---|---:|---|---|---:|---:|---:|
| 1 | 2 | Swap mid and high | [0,0,2,1,1,2] | 0 | 0 | 4 |
| 2 | 0 | Swap low and mid | [0,0,2,1,1,2] | 1 | 1 | 4 |
| 3 | 0 | Swap low and mid | [0,0,2,1,1,2] | 2 | 2 | 4 |
| 4 | 2 | Swap mid and high | [0,0,1,1,2,2] | 2 | 2 | 3 |
| 5 | 1 | Increment mid | [0,0,1,1,2,2] | 2 | 3 | 3 |
| 6 | 1 | Increment mid | [0,0,1,1,2,2] | 2 | 4 | 3 |

**Final Output:**
```text
[0,0,1,1,2,2]
```

The loop stops because `mid > high`.

### Complexity Analysis

- **Time Complexity:** O(n) – Each element is processed a constant number of times.
- **Space Complexity:** O(1) – Only three pointers and a temporary variable are used.

---

## Complexity Comparison

| Feature | Counting Sort | Dutch National Flag |
|---|---|---|
| Time Complexity | O(n) | O(n) |
| Space Complexity | O(1) | O(1) |
| Traversals | 2 | 1 |
| Technique | Counting | Three Pointers |

## 🔑 Key Concepts

- Counting Sort
- Two Pointers / Three Pointers
- In-place Sorting
- Dutch National Flag Algorithm

## 🎯 Interview Note

Both approaches are optimal in time and space complexity.

However, the **Dutch National Flag Algorithm** is preferred because it sorts the array in a single traversal using three pointers.

**Important:** When `nums[mid] == 2`, decrement `high` but do not increment `mid`, because the swapped element has not been checked yet.

   - `low = 0`
   - `mid = 0`
   - `high = nums.length - 1`
2. Traverse while `mid <= high`:
   - If `nums[mid] == 0`:
     - Swap `nums[low]` and `nums[mid]`.
     - Increment both `low` and `mid`.
   - If `nums[mid] == 1`:
     - Increment `mid`.
   - If `nums[mid] == 2`:
     - Swap `nums[mid]` and `nums[high]`.
     - Decrement `high`.
     - Do **not** increment `mid` because the swapped element must be checked.
3. Continue until `mid > high`.

## Complexity

- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

## Java Code

```java
// Solution is available in 75-Sort-Colors.java
```