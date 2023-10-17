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
            int N = Integer.parseInt(in.readLine());
            int graph[][] = new int[N][N];
            
            for(int i = 0;i < N;i++)
                {String a[] = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                graph[i][j] = Integer.parseInt(a[j]);}
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
               { for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
            System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static void helper(int curr,List<Integer>[] graphy,int i,ArrayList<ArrayList<Integer>> output)
    {
        // System.out.println(graphy[i]);
        for(int x:graphy[i])
        {
        // System.out.println(x);
            if(output.get(curr).get(x)==1)
                continue;
            output.get(curr).set(x,1);
            helper(curr,graphy,x,output);
        }
        return;
    }
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][])
    {
        ArrayList<ArrayList<Integer>> output=new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            ArrayList<Integer> curr=new ArrayList<>();
            for(int j=0;j<N;j++)
            {
                if(i==j)
                    curr.add(1);
                else
                    curr.add(0);
            }
            output.add(curr);
        }
        List<Integer>[] graphy=new ArrayList[N];
        for(int i=0;i<N;i++)
        {
            graphy[i]=new ArrayList<>();
            for(int j=0;j<N;j++)
            {
                if(graph[i][j]==1)
                    graphy[i].add(j);
            }
        }
        // for(int i=0;i<N;i++)
        // System.out.println(graphy[i]);
        for(int i=0;i<N;i++)
        {
            helper(i,graphy,i,output);
        }
        return output;
    }
}