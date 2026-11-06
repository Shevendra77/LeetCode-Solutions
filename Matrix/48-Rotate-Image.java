class Solution {
    public void rotate(int[][] matrix) {

        int n = matrix.length;

        // 1. Transpose in place
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        // 2. Reverse each row using two pointers
        for (int row = 0; row < n; row++) {
            int stCol = 0, endCol = n - 1;
            while (stCol < endCol) {
                int tmp = matrix[row][stCol];
                matrix[row][stCol] = matrix[row][endCol];
                matrix[row][endCol] = tmp;
                stCol++;
                endCol--;
            }
        }
    }
}