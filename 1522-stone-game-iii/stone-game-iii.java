class Solution {
    int n;
    int dp[];
    int helper(int[] stones,int ind)
    {
        if(ind==n)
            return 0;
        if(dp[ind]!=-1)
            return dp[ind];
        // if(isAlice)
        // {
            int res=-(int)1e9;
            int value=0;
            for(int i=ind;i<n && i<ind+3;i++)
            {
                value+=stones[i];
                res=Math.max(res,value-helper(stones,i+1));
            }
            return dp[ind]=res;
        // }
        // else{
        //     int res=(int)1e9;
        //     // int value=0;
        //     for(int i=ind;i<n && i<ind+3;i++)
        //     {
        //         // value+=stones[i];
        //         res=Math.min(res,helper(stones,true,i+1));
        //     }
        //     return dp[ind][isAlice?1:0]=res;
        // }
    }
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        // int total=0;
        // for(int x:stoneValue)
        //     total+=x;
        dp=new int[n];
        Arrays.fill(dp,-1);
        int res=helper(stoneValue,0);
        // System.out.println(res);
        if(res==0)
            return "Tie";
        else if(res>0)
            return "Alice";
        return "Bob";
    }
}