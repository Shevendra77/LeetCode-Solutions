class Solution {
    public void rotateMatrix(int[][] mat) {
        
        int n = mat.length;
         //   // 1. reverse the each row of matrix  usign two pinter
        for(int  row = 0; row < n; row++)
        {
            int stCol = 0, endCol = n-1;
            while(stCol <= endCol)
            {
              int tmp = mat[row][stCol];
              mat[row][stCol] = mat[row][endCol];
              mat[row][endCol] = tmp;
              stCol++;
              endCol--;
            }
        }
  
        // 2. reverse the each row of matrix
        
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }
        }
        
       
        
    }
}