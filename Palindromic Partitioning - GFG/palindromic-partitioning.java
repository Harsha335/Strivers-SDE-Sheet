//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    // static Boolean dp[][];
    static boolean isPal(String s,int i,int j,int n)
    {
        // System.out.print(i+"."+j+"-");
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;j--;
        }
        return true;
        // if(i<0 || j>=n)
        //     return true;
        // if(dp[i][j]!=null)
        //     return dp[i][j];
        // if(s.charAt(i)!=s.charAt(j))
        // {
        //     dp[i][j]=false;
        //     return false;
        // }
        // return dp[i][j]=isPal(s,i-1,j+1,n);
    }
    static int dp[][];
    static int helper(String s,int i,int j,int n)
    {
        if(i==n)
            return 0;
        if(j==n)
            return n;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=n;
        // System.out.print(i+"-"+j+"--");
        if(isPal(s,i,j,n))
        {
            ans=1+helper(s,j+1,j+1,n);
        }
        // else if(j==n-1)
        // {
        //     return n;
        // }
        return dp[i][j]=Math.min(ans,helper(s,i,j+1,n));
    }
    static int palindromicPartition(String str)
    {
        dp=new int[str.length()][str.length()];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        // dp=new Boolean[str.length()+1][str.length()+1];
        return helper(str,0,0,str.length())-1;
    }
}