//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    int dir[][]=new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int dfs(int[][] grid,int i,int j,int n,int island)
    {
        int ans=0;
        for(int d[]:dir)
        {
            int x=d[0]+i;
            int y=d[1]+j;
            if(x>=0 && y>=0 && x<n && y<n && grid[x][y]==1)
            {
                grid[x][y]=island;
                ans+=1+dfs(grid,x,y,n,island);
                // System.out.println(grid[x][y]);
            }
        }
        return ans;
    }
    public int largestIsland(int N,int[][] grid) 
    {
        HashMap<Integer,Integer> counter=new HashMap<>();
        int island=2;
        int output=0;
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(grid[i][j]==1)
                {
                    grid[i][j]=island;
                    counter.put(island,1+dfs(grid,i,j,N,island));
                    // System.out.println(grid[i][j]);
                    output=Math.max(output,counter.get(island));
                    island++;
                }
            }
        }
        // System.out.println(counter);
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                int ans=0;
                if(grid[i][j]==0)
                {
                    HashSet<Integer> set=new HashSet<>();
                    for(int d[]:dir)
                    {
                        int x=d[0]+i;
                        int y=d[1]+j;
                        if(x>=0 && y>=0 && x<N && y<N && grid[x][y]!=0)
                        {
                            if(!set.contains(grid[x][y]))
                            {
                                // System.out.println(grid[x][y]);
                                ans+=counter.get(grid[x][y]);
                                set.add(grid[x][y]);
                            }
                        }
                    }
                }
                output=Math.max(ans+1,output);
            }
        }
        return output;
    }
}
