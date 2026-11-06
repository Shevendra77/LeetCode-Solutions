// Solution 1: In-place swap, then copy into ArrayList
// Time: O(n^2), Space: O(n^2) (modifies mat)

class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {

        int n = mat.length;

        // In-place transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }

        // Copy into the required return type
        ArrayList<ArrayList<Integer>> tMat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(mat[i][j]);
            }
            tMat.add(row);
        }
        return tMat;
    }
}

//

// Solution 2: Read columns directly into a new ArrayList
// Time: O(n^2), Space: O(n^2) (input unchanged)

class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] mat) {

        int n = mat.length;
        ArrayList<ArrayList<Integer>> tMat = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(mat[j][i]);
            }
            tMat.add(row);
        }
        return tMat;
    }
}