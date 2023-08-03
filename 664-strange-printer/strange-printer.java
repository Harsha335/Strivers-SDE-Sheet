class Solution {
    int dp[][];
    int helper(String s,int n,int i,int j)
    {
        if(i==j)return 1;
        if(dp[i][j]!=-1)return dp[i][j];
        int min=n;
        for(int k=i;k<j;k++)
        {
            min=Math.min(min,helper(s,n,i,k)+helper(s,n,k+1,j));
        }
        if(s.charAt(i)==s.charAt(j))return dp[i][j]=min-1;
        return dp[i][j]=min;
    }
    public int strangePrinter(String s) {
        int n=s.length();
        dp=new int[n][n];
        for(int[] x:dp)Arrays.fill(x,-1);
        return helper(s,n,0,n-1);
    }
}