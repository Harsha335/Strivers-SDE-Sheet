class Solution {
    private final int mod=(int)1e9+7;
    private long counter(long n)
    {
        return (n*(n+1))%mod/2;
    }
    public int countHomogenous(String s) {
        long ans=0;
        int start=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)!=s.charAt(start))
            {
                ans+=counter((long)i-start);
                ans=(ans)%mod;
                start=i;
            }
        }
        ans+=counter(n-start);
        return (int)(ans)%mod;
    }
}