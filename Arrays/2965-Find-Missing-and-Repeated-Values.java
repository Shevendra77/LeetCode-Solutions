class Solution 
{
    public int[] findMissingAndRepeatedValues(int[][] grid) 
    {
        HashSet <Integer> set =  new HashSet <> () ;

        int n = grid.length;

        int repeating = 0;
        int missing = 0 ;
        int actualSum = 0;
        int expectedSum = 0;

        for (int i = 0 ; i < n ; i++)
        {
            for (int j = 0 ; j < n ; j++)
            {
                actualSum += grid[i][j];

                if (set.contains(grid[i][j]))
                {
                    repeating = grid[i][j];
                }
                else
                {
                    set.add(grid[i][j]);
                }
                expectedSum = (n * n) * (n * n + 1) / 2;

                missing = expectedSum + repeating - actualSum ;

            }
        }
        return new int [] {repeating , missing} ;
    }
}