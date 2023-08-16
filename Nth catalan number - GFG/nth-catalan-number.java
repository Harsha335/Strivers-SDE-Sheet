//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.findCatalan(n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod=(int)1e9+7;
    static int dp[][];
    static int helper(int open,int close)
    {
        if(open==0 && close==0) return 1;
        // if(open==0 || close==0) return -(int)1e9;
        if(dp[open][close]!=-1) return dp[open][close];
        int take=0;
        if(open>0){
            take=helper(open-1,close);
        }
        int notTake=0;
        if(open<close)
            notTake=helper(open,close-1);
        return dp[open][close]=(take+notTake)%mod;
    }
    public static int findCatalan(int n) {
        dp=new int[n+1][n+1];
        for(int[] x:dp) Arrays.fill(x,-1);
        return helper(n,n);
    }
}
        
