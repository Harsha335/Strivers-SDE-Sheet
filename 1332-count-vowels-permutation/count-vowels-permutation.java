class Solution {
    private int mod = (int)1e9 + 7;
    HashMap<Character,List<Character>> map;
    long dp[][];
    private long dfs(char c,int n)
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[c-'a'][n]!=-1)
            return dp[c-'a'][n];
        long ans=0;
        for(char x:map.get(c))
        {
            ans+=dfs(x,n-1);
            ans=(ans)%mod;
        }
        return dp[c-'a'][n]=ans;
    }
    public int countVowelPermutation(int n) {
        map=new HashMap<>();
        map.put('a',Arrays.asList('e'));
        map.put('e',Arrays.asList('a','i'));
        map.put('i',Arrays.asList('a','e','o','u'));
        map.put('o',Arrays.asList('i','u'));
        map.put('u',Arrays.asList('a'));
        long count=0;
        dp=new long[26][n];
        for(long x[]:dp)
            Arrays.fill(x,-1);
        for(char key:map.keySet())
        {
            count+=dfs(key,n-1);
            count=(count)%mod;
        }
        return (int)count;
    }
}