//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    boolean helper(int[][] matrix,int i,int j)
    {
        int n=matrix.length,m=matrix[0].length;
        int dir[][]=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int ct=0;
        for(int[] d:dir)
        {
            int x=d[0]+i;
            int y=d[1]+j;
            if(x>=0 && y>=0 && x<n && y<m && matrix[x][y]==0) ct++;
        }
        // System.out.println(i+" "+j+" "+ct);
        return ct>0 && ct%2==0;
    }
    public int  Count(int[][] matrix)
    {
        int count=0;
        int n=matrix.length,m=matrix[0].length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==1 && helper(matrix,i,j)) count++;
            }
        }
        return count;
    }
}