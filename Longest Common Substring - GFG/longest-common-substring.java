//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    //YYYYYYYYYYYYYYYYYYYYYYYY
    
    // int dp[][][];
    // int helper(String s1,String s2,int i,int j,boolean isStart)
//     {
//         if(i==-1 || j==-1)return 0;
//         if(dp[i][j][isStart?1:0]!=-1) return  dp[i][j][isStart?1:0];
//         int maxi=0;
//         if(s1.charAt(i)==s2.charAt(j))
//         {
//             System.out.println(s1.charAt(i)+" "+i+" "+j);
//             maxi=1+helper(s1,s2,i-1,j-1,true);
//         }
// //         12 12
// // gvhjhjhbjrfh
// // jjljnklhjkjh
//         // else{
//             else if(isStart) 
//             {
//                 System.out.println(s1.charAt(i)+"---"+i+"---"+j);
//                 return 0;
//             }
//             maxi=Math.max(maxi,helper(s1,s2,i-1,j-1,false));
//             maxi=Math.max(maxi,helper(s1,s2,i-1,j,false));
//             maxi=Math.max(maxi,helper(s1,s2,i,j-1,false));
//         // }
//         System.out.println(i+" "+j+" "+isStart+" "+maxi);
//         return dp[i][j][isStart?1:0]=maxi;
//     }
    int longestCommonSubstr(String s1, String s2, int n, int m){
        // dp=new int[n][m][2];
        // for(int x[][]:dp)
        // {
        //     for(int xx[]:x)
        //     {
        //         Arrays.fill(xx,-1);
        //     }
        // }
        // return helper(s1,s2,n-1,m-1,false);
        
        
        
        
        int[][] dp = new int[n][m];
        int output=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(s1.charAt(i)==s2.charAt(j))
                {
                    if(i>0 && j>0)
                    {
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    else
                        dp[i][j]=1;
                    output=Math.max(output,dp[i][j]);
                }
            }
        }
        return output;
        
    }
}