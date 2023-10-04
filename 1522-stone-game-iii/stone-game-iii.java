class Solution {
    int n;
    int dp[][];
    int helper(int[] stones,boolean isAlice,int ind)
    {
        if(ind==n)
            return 0;
        if(dp[ind][isAlice?1:0]!=-1)
            return dp[ind][isAlice?1:0];
        if(isAlice)
        {
            int res=-(int)1e9;
            int value=0;
            for(int i=ind;i<n && i<ind+3;i++)
            {
                value+=stones[i];
                res=Math.max(res,helper(stones,false,i+1)+value);
            }
            return dp[ind][isAlice?1:0]=res;
        }
        else{
            int res=(int)1e9;
            // int value=0;
            for(int i=ind;i<n && i<ind+3;i++)
            {
                // value+=stones[i];
                res=Math.min(res,helper(stones,true,i+1));
            }
            return dp[ind][isAlice?1:0]=res;
        }
    }
    public String stoneGameIII(int[] stoneValue) {
        n=stoneValue.length;
        int total=0;
        for(int x:stoneValue)
            total+=x;
        dp=new int[n][2];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        int res=helper(stoneValue,true,0);
        // System.out.println(res);
        if((double)res==(double)total/2.0)
            return "Tie";
        else if((double)res>(double)total/2.0)
            return "Alice";
        return "Bob";
    }
}