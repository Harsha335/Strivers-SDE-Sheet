class Solution {
    int dp[][];
    int mod=(int)1e9+7;
    int helper(int n,int k,int tar)
    {
        if(tar<0)
            return 0;
        if(n<0)
        {
            if(tar==0)  return 1;
            return 0;
        }
        if(dp[n][tar]!=-1)
            return dp[n][tar];
        long output=0;
        for(int i=1;i<=k;i++)
        {
            output+=helper(n-1,k,tar-i);
            output=output%mod;
        }
        return dp[n][tar]=(int)output;
    }
    public int numRollsToTarget(int n, int k, int target) {
        dp=new int[n][target+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(n-1,k,target);
    }
}