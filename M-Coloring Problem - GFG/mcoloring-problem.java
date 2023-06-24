//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    boolean isSafe(int[] color,List<Integer> graph[],int cur,int choosen)
    {
        for(int child:graph[cur])
        {
            if(color[child]==choosen)
                return false;
        }
        return true;
    }
    boolean helper(int[] color,List<Integer> graph[],int cur,int m,int n)
    {
        // for(int child:graph[cur])
        // {
        //     if(color[child]!=-1)
        //     {
        //         if(color[child]==color[cur])return false;
        //         continue;
        //     }
        if(cur==n)return true;
            for(int i=0;i<m;i++)
            {
                if(isSafe(color,graph,cur,i))
                {
                    color[cur]=i;
                    if(helper(color,graph,cur+1,m,n))
                        return true;
                    color[cur]=-1;
                }
            }
            return false;
        // }
        // return true;
    }
    public boolean graphColoring(boolean g[][], int m, int n) {
        List<Integer> graph[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            graph[i]=new ArrayList<>();
        }
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                // System.out.println(g[i][j]);
                if(g[i][j])
                {
                    graph[i].add(j);
                    // graph[j].add(i);
                }
            }
        }
        // for(List<Integer> x:graph)
        //     System.out.println(x);
        return helper(color,graph,0,m,n);
        // for(int i=0;i<n;i++)
        // {
        //     if(color[i]==-1)
        //     {
        //         color[i]=0;
        //         if(!helper(color,graph,i,m))
        //             return false;
        //     }
        // }
        // return true;
    }
}