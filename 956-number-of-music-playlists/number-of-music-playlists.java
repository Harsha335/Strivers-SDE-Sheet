class Solution {
    int mod=(int)(1e9)+7;
    long dp[][];
    long helper(int unique,int size,int k,int total_n)
    {
        if(size==0 && unique==0)
        {
            return 1;
        }
        if(size==0 || unique==0) return 0;
        if(dp[unique][size]!=-1) return dp[unique][size];
        //taking new
        long ans=((total_n-unique+1)*(helper(unique-1,size-1,k,total_n)))%mod;
        //old
        if(unique>k)
            ans=(ans+((unique-k)*(helper(unique,size-1,k,total_n)))%mod)%mod;
        return dp[unique][size]=ans;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        dp=new long[n+1][goal+1];
        for(long[] x:dp) Arrays.fill(x,-1);
        return (int)helper(n,goal,k,n)%mod;
    }
}