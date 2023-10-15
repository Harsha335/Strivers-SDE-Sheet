class Solution {
    private int dir[]=new int[]{-1,0,1};
    private int mod=(int)1e9+7;
    private int dp[][];
    private int helper(int pos,int steps,int arrLen)
    {
        if(pos<1 || pos>arrLen)
            return 0;
        if(steps==0)
        {
            if(pos==1)  
                return 1;
            return 0;
        }
        if(dp[pos][steps]!=-1)
            return dp[pos][steps];
        int ans=0;
        for(int d:dir)
        {
            ans=(ans+helper(pos+d,steps-1,arrLen))%mod;
        }
        return dp[pos][steps]=ans;
    }
    public int numWays(int steps, int arrLen) {
        arrLen=Math.min(arrLen,steps);//THIS MOVE\U0001f44d
        dp=new int[arrLen+1][steps+1];
        for(int x[]:dp)
        {
            Arrays.fill(x,-1);
        }
        return helper(1,steps,arrLen);
    }
}