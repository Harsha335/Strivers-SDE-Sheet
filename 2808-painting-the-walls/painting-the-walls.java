class Solution {
    private int dp[][];
    private int helper(int i,int n,int cost[],int time[],int remaining)
    {
        if(remaining<=0)
            return 0;
        if(i==n)
            return (int)1e9;
        if(dp[i][remaining]!=-1)
            return dp[i][remaining];
        int taken=cost[i]+helper(i+1,n,cost,time,remaining-1-time[i]);
        int notTake=helper(i+1,n,cost,time,remaining);
        return dp[i][remaining]=Math.min(taken,notTake);
    }
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        dp=new int[n][n+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(0,n,cost,time,n);
    }
}