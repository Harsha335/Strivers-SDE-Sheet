class Solution {
    private final int mod=(int)1e9+7;
    // private long counter(long n)
    // {
    //     return ((((n*(n+1)%mod))%mod)/2)%mod;
    // }
    public int countHomogenous(String s) {
        // int start=0;
        long n=s.length();
        long counter=1;
        long ans=1;
        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                // ans+=counter((long)i-start);
                counter++;
                // start=i;
            }
            else{
                counter=1;
            }
            ans+=counter;
            ans=(ans)%mod;
            // System.out.println(counter+" "+i);
        }
        // ans+=counter(n-start);
        // ans+=counter;
        return (int)(ans)%mod;
    }
}