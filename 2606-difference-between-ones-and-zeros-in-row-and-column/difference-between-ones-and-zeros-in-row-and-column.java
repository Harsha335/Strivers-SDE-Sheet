class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        int rowCounter[]=new int[n];
        int colCounter[]=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    rowCounter[i]+=1;
                    colCounter[j]+=1;
                }
            }
        }
        int output[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                output[i][j]=rowCounter[i]+colCounter[j]-(m-rowCounter[i])-(n-colCounter[j]);
            }
        }
        return output;
    }
}