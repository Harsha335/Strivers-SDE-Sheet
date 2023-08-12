class Solution {
    int n;
    int m;
    int dp[][];
    int helper(int[][] board,int i,int j){
        if(i==0 && j==0){
            return 1;
        }
        if(i<0 || j<0 || i>=n || j>=m || board[i][j]==1){
            return 0;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        dp[i][j]=helper(board,i-1,j)+helper(board,i,j-1);
        return dp[i][j];
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        n=obstacleGrid.length;
        m=obstacleGrid[0].length;
        dp=new int[n][m];
        for(int[] x:dp){
            Arrays.fill(x,-1);
        }
        if(obstacleGrid[0][0]==1 || obstacleGrid[n-1][m-1]==1)
            return 0;
        return helper(obstacleGrid,n-1,m-1);
    }
}