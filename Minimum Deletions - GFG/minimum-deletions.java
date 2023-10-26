//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String S = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.minimumNumberOfDeletions(S));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int dp[][];
    static int helper(String s,int i,int j)
    {
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        if(s.charAt(i)==s.charAt(j))
            return dp[i][j]=helper(s,i+1,j-1);
        return dp[i][j]=1+Math.min(helper(s,i+1,j),helper(s,i,j-1));
    }
    static int minimumNumberOfDeletions(String S) {
        dp=new int[S.length()][S.length()];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(S,0,S.length()-1);
    }
}