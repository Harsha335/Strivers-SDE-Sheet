class Solution {
    private int mod = (int)1e9 + 7;
    HashMap<Integer,List<Integer>> map;
    long dp[][];
    private long dfs(int c,int n)
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[c][n]!=-1)
            return dp[c][n];
        long ans=0;
        for(int x:map.get(c))
        {
            ans+=dfs(x,n-1);
            ans=(ans)%mod;
        }
        return dp[c][n]=ans;
    }
    public int countVowelPermutation(int n) {
        //  a: 0, e: 1, i: 2, o: 3, u: 4
        map=new HashMap<>();
        map.put(0,Arrays.asList(1));
        map.put(1,Arrays.asList(0,2));
        map.put(2,Arrays.asList(0,1,3,4));
        map.put(3,Arrays.asList(2,4));
        map.put(4,Arrays.asList(0));
        long count=0;
        dp=new long[5][n];
        for(long x[]:dp)
            Arrays.fill(x,-1);
        for(int i=0;i<5;i++)
        {
            count+=dfs(i,n-1);
            count=(count)%mod;
        }
        return (int)count;
    }
}