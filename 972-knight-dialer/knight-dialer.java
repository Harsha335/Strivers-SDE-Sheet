class Solution {
    long dp[][][];
    long mod=(long)1e9+7;
    int dir[][]=new int[][]{{-2,-1},{-2,1},{-1,-2},{-1,2},{1,2},{1,-2},{2,1},{2,-1}};
    private boolean isPossible(int i,int j)
    {
        return i>=0 && (i<=2 || (i==3 && j==1)) && j>=0 && (j<=2 || (j==1 && i==3));
    }
    long helper(int i,int j,int n)
    {
        if(n==0)
            return 1;
        // System.out.println(i+" "+j+" "+n);
        if(dp[i][j][n]!=-1)
            return dp[i][j][n];
        long out=0;
        for(int d[]:dir)
        {
            int x=d[0]+i;
            int y=d[1]+j;
            if(isPossible(x,y))
            {
                out=(out+helper(x,y,n-1))%mod;
            }
        }
        return dp[i][j][n]=out;
    }
    public int knightDialer(int n) {
        if(n==1)
            return 10;
        dp=new long[4][3][n];
        for(long x[][]:dp)
        {
            for(long xx[]:x)
                Arrays.fill(xx,-1);
        }
        long output=0;
        output=(output+helper(1,0,n-2))%mod;
        output=(output+helper(1,2,n-2))%mod;
        for(int i=1;i<=9;i++)
            output=(output+helper((i-1)/3,(i-1)%3,n-1))%mod;
        return (int)(output%mod); 
    }
}