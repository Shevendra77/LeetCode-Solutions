class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;

        // Create an array to store the final answer
        int[] res = new int[n];

        // STEP 1: Initialize the first index with 1
        // Because there is no element on the left of index 0
        res[0] = 1;

        // STEP 2: Calculate prefix product (left product)
        for (int i = 1; i < n; i++) {

            // Previous prefix product * previous element
            res[i] = res[i - 1] * nums[i - 1];
        }

        // STEP 3: Initialize right product with 1
        // Because there is no element on the right of the last index
        int rightProd = 1;

        // STEP 4: Traverse from right to left
        for (int r = n - 1; r >= 0; r--) {

            // Multiply left product with right product
            // This gives the product of all elements except nums[r]
            res[r] = res[r] * rightProd;

            // Update right product for the next iteration
            rightProd = rightProd * nums[r];
        }
        
        return res;
    }
}