class Solution {
    int n1,n2;
    int dp[][];
    boolean helper(int i,int j,String s1,String s2,String s3)
    {
        if(i==n1 && j==n2) return true;
        if(dp[i][j]!=-1) return false; //dp[i][j]==0?false:true;
        if(i<n1 && s1.charAt(i)==s3.charAt(i+j))
        {
            if(helper(i+1,j,s1,s2,s3)) return true;
        }
        if(j<n2 && s2.charAt(j)==s3.charAt(i+j))
        {
            if(helper(i,j+1,s1,s2,s3)) return true;
        }
        dp[i][j]=0;
        return false;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        n1=s1.length();
        n2=s2.length();
        if(n1+n2!=s3.length()) return false;
        dp=new int[n1+1][n2+1];
        for(int x[]:dp)
        {
            Arrays.fill(x,-1);
        }
        return helper(0,0,s1,s2,s3);
    }
}