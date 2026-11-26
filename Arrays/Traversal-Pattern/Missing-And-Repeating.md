# Find the Repeating and Missing Number

## Problem Statement

Given an array of size `n` containing numbers from `1` to `n`, one number appears twice and one number is missing. Find both numbers.

## Example

**Input:**

```java
arr[] = {1, 3, 3}
```

**Output:**

```java
[3, 2]
```

**Explanation:**

- 3 is repeating because it appears twice.
- 2 is missing because it does not appear in the array.

## Approach: Frequency Array

1. Calculate the size of the array and store it in `n`.
2. Create a frequency array of size `n + 1`, initialized with zeros.
3. Initialize `repeating` and `missing` variables with `-1`.
4. Traverse the input array from index `0` to `n-1`.
5. Increase the frequency of each element using `freq[arr[i]]++`.
6. Traverse the frequency array from index `1` to `n`.
7. If the frequency of a number is `2`, it is the repeating number.
8. If the frequency of a number is `0`, it is the missing number.
9. Store both numbers in an ArrayList, repeating first and missing second.
10. Return the ArrayList.

## Java Code

```java
class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {

        int n = arr.length;

        int freq[] = new int[n + 1];

        int missing = -1;
        int repeating = -1;

        // Count frequency of every number
        for (int i = 0; i < n; i++) {
            freq[arr[i]]++;
        }

        // Find repeating and missing numbers
        for (int i = 1; i <= n; i++) {

            if (freq[i] == 2) {
                repeating = i;
            }

            if (freq[i] == 0) {
                missing = i;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        res.add(repeating);
        res.add(missing);

        return res;
    }
}
```

## Dry Run

**Input:**

```java
arr[] = {1, 3, 3}
n = 3
```

**Frequency Array:**

| Number | Frequency |
|--------|----------:|
| 1      | 1         |
| 2      | 0         |
| 3      | 2         |

**Result:**

- Repeating = 3
- Missing = 2

**Output:** `[3, 2]`

## Complexity Analysis

- **Time Complexity:** O(n)
  - First loop takes O(n) to count frequencies.
  - Second loop takes O(n) to find repeating and missing numbers.

- **Space Complexity:** O(n)
  - The frequency array requires O(n) extra space.

## Key Learning

A frequency array stores how many times each element occurs.

- `freq[i] == 0` → Missing number.
- `freq[i] == 1` → Number appears once.
- `freq[i] == 2` → Repeating number.