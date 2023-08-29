class Solution {
    boolean helper(int[][] graph,int curr,int color[])
    {
        for(int nei:graph[curr])
        {
            if(color[nei]==-1 && curr!=nei)
            {
                color[nei]=1-color[curr];
                if(!helper(graph,nei,color))
                    return false;
            }
            else if(color[nei]==color[curr])
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1) 
            {
                color[i]=0;
                if(!helper(graph,i,color)) 
                    return false;
            }
        }
        return true;
    }
}