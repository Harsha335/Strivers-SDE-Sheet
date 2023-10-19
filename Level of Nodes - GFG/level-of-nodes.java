//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for(int i = 0; i < V+1; i++)
                list.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++)
            {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
                list.get(v).add(u);
            }
            int X = sc.nextInt();
            
            Solution ob = new Solution();
            
            System.out.println(ob.nodeLevel(V,list,X));
        }
    }
}
// } Driver Code Ends




/*Complete the function below*/

class Solution
{
    //CYCLIC GRAPH SO DFS WONT WORK
    // int helper(int curr,int parent,ArrayList<ArrayList<Integer>> adj,int x,int level)
    // {
    //     if(curr==x)
    //         return level;
    //     for(int ele:adj.get(curr))
    //     {
    //         if(ele==parent)
    //             continue;
    //         int ans=helper(ele,curr,adj,x,level+1);
        
    //         if(ans!=-1)
    //             return ans;
    //     }
    //     return -1;
    // }
    //Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // return helper(0,-1,adj,X,0);
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        boolean visited[]=new boolean[V];
        int level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size-->0)
            {
                int curr=q.poll();
                // if(visited[curr])
                //     continue;
                // visited[curr]=true;
                for(int ele:adj.get(curr))
                {
                    if(!visited[ele])
                    {
                        if(ele==X)
                            return level+1;
                        visited[ele]=true;
                        q.add(ele);
                    }
                }
            }
            level+=1;
        }
        return -1;
    }
}