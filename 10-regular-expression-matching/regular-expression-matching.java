class Solution {
    int dp[][];
    boolean helper(String s1,String s2,int i,int j)
    {
        // System.out.println(i+" "+j);
        if(i==-1 && j==-1) return true;
        if(i==-1 || j==-1){
            while(j>=1 && s2.charAt(j)=='*')
            {
                j-=2;
            }
            return i==-1 && j==-1;
        }
        if(dp[i][j]!=-1) return false;
        if(s1.charAt(i)==s2.charAt(j) || s2.charAt(j)=='.')
        {
            if(helper(s1,s2,i-1,j-1))
                return true;
        }
        else if(s2.charAt(j)=='*')
        {
            if(s2.charAt(j-1)==s1.charAt(i) || s2.charAt(j-1)=='.')
            {
                if(helper(s1,s2,i-1,j)) 
                    return true;
            }
            if(helper(s1,s2,i,j-2))
                return true;
        }
        dp[i][j]=0;
        return false;

    }
    public boolean isMatch(String s, String p) {
        int n1=s.length();
        int n2=p.length();
        dp=new int[n1][n2];
        for(int[] x:dp)
            Arrays.fill(x,-1);
        return helper(s,p,n1-1,n2-1);
    }
}