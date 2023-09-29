//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean visited[][];
    int dir[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    int n,m;
    int dfs(int[][] grid,int i,int j)
    {
        if(visited[i][j])return 0;
        visited[i][j]=true;
        int count=0;
        for(int d[]:dir)
        {
            int x=i+d[0];
            int y=j+d[1];
            if(x>=0 && y>=0 && x<n && y<m && grid[x][y]==1)
                count+=dfs(grid,x,y);
        }
        return count+1;
    }
    int numberOfEnclaves(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    count++;
                    if(i==0 || j==0 || i==n-1 || j==m-1)
                    {
                        count-=dfs(grid,i,j);
                    }
                }
            }
        }
        return count;
    }
}