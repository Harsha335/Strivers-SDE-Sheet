class Solution {
    int dp[];
    int helper(String s,int n)
    {
        if(n==-1)
            return 1;
        if(dp[n]!=-1)
            return dp[n];
        int one=0,two=0;
        if(s.charAt(n)!='0')
            one=helper(s,n-1);
        if(n>0 && (s.charAt(n-1)=='1' || (s.charAt(n-1)=='2' && s.charAt(n)<='6')))
            two=helper(s,n-2);
        return dp[n]=one+two;
    }
    public int numDecodings(String s) {
        int n=s.length();
        dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(s,n-1);
    }
}