
class Solution {
    public List<Integer> spiralOrder(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int stRow = 0, endRow = m - 1;
        int stCol = 0, endCol = n - 1;

        ArrayList<Integer> list = new ArrayList<>();

        while (stRow <= endRow && stCol <= endCol) {

            // Top Boundary
            for (int j = stCol; j <= endCol; j++) {
                list.add(mat[stRow][j]);
            }

            // Right Boundary
            for (int i = stRow + 1; i <= endRow; i++) {
                list.add(mat[i][endCol]);
            }

            // Bottom Boundary
            for (int j = endCol - 1; j >= stCol; j--) {
                if (stRow == endRow) {
                    break;
                }
                list.add(mat[endRow][j]);
            }

            // Left Boundary
            for (int i = endRow - 1; i >= stRow + 1; i--) {
                if (stCol == endCol) {
                    break;
                }
                list.add(mat[i][stCol]);
            }

            // Shrink all four boundaries
            stRow++;
            stCol++;
            endRow--;
            endCol--;
        }

        return list;
    }
}