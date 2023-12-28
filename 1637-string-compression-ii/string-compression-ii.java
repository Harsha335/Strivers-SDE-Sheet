class Solution {
    int n;
    int counter(int count)
    {
        if(count==0)
            return -1;
        if(count==1)
            return 0;
        int ans=0;
        while(count>0)
        {
            count/=10;
            ans++;
        }
        return ans;
    }
    Integer dp[][][][];
    int helper(String s, int i, int k , char pre, int count)
    {
        if(i==n)
        {
            return counter(count)+1;
        }
        if(dp[i][k][pre-'a'][count]!=null)
        {
            // System.out.println("HII");
            return dp[i][k][pre-'a'][count];
        }
        int ans=100;
        if(s.charAt(i)==pre)
        {
            ans=helper(s,i+1,k,pre,count+1);
        }
        else
        {

            ans=counter(count)+1+helper(s,i+1,k,s.charAt(i),1);

            if(k>0)
            {
                ans=Math.min(ans,helper(s,i+1,k-1,pre,count));
            }
        }
        return dp[i][k][pre-'a'][count]=ans;
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        n=s.length();
        dp=new Integer[n][k+1][27][n];
        return helper(s,0,k,'{',0);
    }
}

// "njcadlkfmhdljjeihggfligcimilkdhgncnkndlgnlcajkbihkeidcgedibidenjfikbgilknfjflhfcaikgcegaalmmngdmikie"
// 45