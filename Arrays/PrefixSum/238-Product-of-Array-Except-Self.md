# 238. Product of Array Except Self

**LeetCode:** [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

**Constraints worth remembering:** `2 <= n <= 10^5`, and every prefix/suffix product fits in a 32-bit integer. Because `n >= 2`, writing `res[0] = 1` is always safe.

### 🧠 Intuition

We need to calculate the product of all elements except the current element for every index.

**Why not just divide?**
The naive idea is `totalProduct / nums[i]`. It breaks when the array contains `0`:
- One zero → dividing by that zero is undefined.
- Two or more zeros → every answer must be `0`, but division can't express that.

So we avoid division and use **Prefix Product + Suffix Product** instead.

- Prefix Product → Product of all elements on the left.
- Suffix Product → Product of all elements on the right.
- Multiply both products to get the answer for the current index.

**Formula:**

```text
Answer[i] = Prefix Product[i] × Suffix Product[i]
```

### 🪜 First Attempt: Two Extra Arrays (O(N) space)

The most direct version stores the prefix and suffix products separately.

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] res = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }
}
```

This is correct but uses `O(N)` extra space. The optimized version below removes both helper arrays:
- `left[]` is stored directly inside `res`.
- `right[]` is replaced by a single running variable, `rightProd`.

### 🔍 Approach: Prefix Product + Suffix Product (Optimized)

1. Create a result array `res` of size `n`.
2. Initialize `res[0] = 1` because there is no element on the left of index 0.
3. Traverse from left to right and calculate the prefix product.
4. Initialize `rightProd = 1` because there is no element on the right of the last index.
5. Traverse from right to left.
6. Multiply `res[r]` with `rightProd` to get the final product.
7. Update `rightProd` by multiplying it with `nums[r]`.
8. Return the result array.

### 💻 Java Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];

        // Initialize first index with 1
        res[0] = 1;

        // Calculate prefix product (left product)
        for (int i = 1; i < n; i++) {

            res[i] = res[i - 1] * nums[i - 1];
        }

        // Initialize suffix product
        int rightProd = 1;

        // Traverse from right to left
        for (int r = n - 1; r >= 0; r--) {

            // Multiply prefix and suffix product
            res[r] = res[r] * rightProd;

            // Update suffix product
            rightProd *= nums[r];
        }

        return res;
    }
}
```

### 📊 Dry Run

**Input:**

```java
nums = [1, 2, 3, 4]
```

**Step 1: Calculate Prefix Product**

| Index | Element | Calculation | Prefix Product |
|---:|---:|---|---:|
| 0 | 1 | No left element | 1 |
| 1 | 2 | 1 × 1 | 1 |
| 2 | 3 | 1 × 2 | 2 |
| 3 | 4 | 2 × 3 | 6 |

```text
res = [1, 1, 2, 6]
```

**Step 2: Calculate Suffix Product**

Traverse from right to left.

| Index | Element | rightProd | Calculation | res[index] |
|---:|---:|---:|---|---:|
| 3 | 4 | 1 | 6 × 1 | 6 |
| 2 | 3 | 4 | 2 × 4 | 8 |
| 1 | 2 | 12 | 1 × 12 | 12 |
| 0 | 1 | 24 | 1 × 24 | 24 |

**Output:**

```java
[24, 12, 8, 6]
```

### 0️⃣ Example With a Zero

```text
nums   = [1, 0, 3, 4]
Output = [0, 12, 0, 0]
```

Only the index holding the zero gets a non-zero answer (`1 × 3 × 4 = 12`). Every other index has the zero in its product, so it becomes `0`. The prefix/suffix method handles this automatically, with no special casing.

### ⏱️ Complexity Analysis

- **Time Complexity:** `O(N)` – We traverse the array twice, once from left to right and once from right to left.
- **Space Complexity:** `O(1)` auxiliary – Only the output array and one variable (`rightProd`) are used. The output array is not counted as auxiliary space.

### ⭐ Important Points

- `res[i - 1] * nums[i - 1]` calculates the prefix product.
- `rightProd` stores the running suffix product.
- `res[r] * rightProd` combines left and right products.
- We update `rightProd` after calculating the current index so that the current element is excluded.
- We initialize products with `1` because 1 is the multiplicative identity.
- No division is used, so the solution also handles zeros.
- We achieve `O(N)` time complexity with `O(1)` auxiliary space.

**Pattern:** Prefix/Suffix Product (related: Prefix Sum, Running Product)