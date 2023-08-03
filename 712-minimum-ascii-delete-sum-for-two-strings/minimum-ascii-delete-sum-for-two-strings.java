class Solution {
    int n1,n2;
    int dp[][];
    int helper(String s1,String s2,int ind1,int ind2)
    {
        if(ind1==n1 && ind2==n2) return 0;
        if(ind1==n1){
            int ans=0;
            for(int i=ind2;i<n2;i++)
            {
                ans+=(int)s2.charAt(i);
            }
            return ans;
        }
        if(ind2==n2){
            int ans=0;
            for(int i=ind1;i<n1;i++)
            {
                ans+=(int)s1.charAt(i);
            }
            return ans;
        }
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        char c1=s1.charAt(ind1);
        char c2=s2.charAt(ind2);
        if(c1==c2) return dp[ind1][ind2]=helper(s1,s2,ind1+1,ind2+1);
        return dp[ind1][ind2]=Math.min((int)c1+helper(s1,s2,ind1+1,ind2),(int)c2+helper(s1,s2,ind1,ind2+1));
    }
    public int minimumDeleteSum(String s1, String s2) {
        n1=s1.length();
        n2=s2.length();
        dp=new int[n1][n2];
        for(int x[]:dp)Arrays.fill(x,-1);
        return helper(s1,s2,0,0);
    }
}