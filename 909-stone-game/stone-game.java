class Solution {
    int[][][] dp;
    int helper(int piles[],int i,int j,boolean alice)
    {
        if(i==j)
        {
            if(alice)
            return piles[i];
            return -piles[i];
        }
        // System.out.println(dp[i][j][alice?1:0]);
        if(dp[i][j][alice?1:0]!=-1)
            return dp[i][j][alice?1:0];
        if(alice)
        {
            return dp[i][j][alice?1:0]= Math.max(helper(piles,i+1,j,false)+piles[i],helper(piles,i,j-1,false)+piles[j]);
        }
        return dp[i][j][alice?1:0]= - Math.max(helper(piles,i+1,j,true)+piles[i],helper(piles,i,j-1,true)+piles[j]);
    }
    public boolean stoneGame(int[] piles) {
        int total=0;
        int n=piles.length;
        for(int x:piles)
        {
            total+=x;
        }
        dp=new int[n][n][2];
        for(int x[][]:dp)
        {
            for(int xx[]:x)
            {
                Arrays.fill(xx,-1);
            }
        }
        int val=helper(piles,0,n-1,true);
        // System.out.println(val);
        return (total-val)>0;
    }
}