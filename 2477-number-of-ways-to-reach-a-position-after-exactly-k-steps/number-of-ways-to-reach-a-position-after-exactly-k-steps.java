class Solution {
    int mod = (int)1e9+7;
    long dp [][];
    long helper(int curr,int start, int end, int k, int kk)
    {
        // System.out.println(curr +" "+ k);
        if(k == 0)
        {
            return curr == end ? 1 : 0;
        }
        if( Math.abs(curr-end) > k )
            return 0;
        if( dp[curr - start + kk][k] != -1)
            return dp[curr - start + kk][k];
        long ans = helper(curr + 1, start, end , k-1, kk) + helper(curr - 1, start, end , k-1, kk);
        return dp[curr - start + kk][k] = ans%mod;
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        dp = new long[k + k +1][k+1];
        for(long x[]:dp)
            Arrays.fill(x,-1);
        return (int)helper(startPos, startPos, endPos, k, k);
    }
}