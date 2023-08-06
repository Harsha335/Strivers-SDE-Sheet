class Solution {
    int mod=(int)(1e9)+7;
    long dp[][];
    int n;
    int goal;
    int k;
    long helper(int usedSongs,int ind)
    {
        if(usedSongs==n && ind==goal)
        {
            return 1;
        }
        if(ind==goal)
            return 0;
        if(dp[usedSongs][ind]!=-1) return dp[usedSongs][ind];
        //taking new
        long ans=0;
        if(usedSongs<n)
            ans=((n-usedSongs)*(helper(usedSongs+1,ind+1)))%mod;
        //old
        if(usedSongs>k)
            ans=(ans+((usedSongs-k)*(helper(usedSongs,ind+1)))%mod)%mod;
        return dp[usedSongs][ind]=ans;
    }
    public int numMusicPlaylists(int n, int goal, int k) {
        dp=new long[n+1][goal];
        for(long[] x:dp) Arrays.fill(x,-1);
        this.n=n;
        this.goal=goal;
        this.k=k;
        return (int)helper(0,0)%mod;
    }
}