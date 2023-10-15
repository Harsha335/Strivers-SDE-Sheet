class Solution {
    private int dir[]=new int[]{-1,0,1};
    private int mod=(int)1e9+7;
    // private int dp[][];
    HashMap<List<Integer>,Integer> dp;
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
        List<Integer> list=Arrays.asList(pos,steps);
        if(dp.containsKey(list))
            return dp.get(list);
        // if(dp[pos][steps]!=-1)
        //     return dp[pos][steps];
        int ans=0;
        for(int d:dir)
        {
            ans=(ans+helper(pos+d,steps-1,arrLen))%mod;
        }
        // dp[pos][steps]=
        dp.put(list,ans);
        return ans;
    }
    public int numWays(int steps, int arrLen) {
        // dp=new int[arrLen+1][steps+1];
        // for(int x[]:dp)
        // {
        //     Arrays.fill(x,-1);
        // }
        dp=new HashMap<>();

        return helper(1,steps,arrLen);
    }
}