//  Binary Search on Entire Matrix
class Solution {
    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Convert 1D index into 2D coordinates
            int row = mid / n;
            int col = mid % n;

            if (mat[row][col] == target) {
                return true;
            }
            else if (mat[row][col] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}

// Find Row + Binary Search in Row

class Solution1 {
    public boolean searchMatrix(int[][] mat, int target) {

        int m = mat.length;
        int n = mat[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            // Convert 1D index into 2D coordinates
            int row = mid / n;
            int col = mid % n;

            if (mat[row][col] == target) {
                return true;
            }
            else if (mat[row][col] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return false;
    }
}