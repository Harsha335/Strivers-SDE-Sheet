class Solution {
    private int dfs(int ele,int parent,List<int[]> map[])
    {
        int ans=0;
        for(int[] x:map[ele])
        {
            if(parent!=x[0])
                ans+=x[1]+dfs(x[0],ele,map);
        }
        return ans;
    }
    private void helper(int curr,int parent,int[] cost,List<int[]> map[])
    {
        for(int[] x:map[curr])
        {
            if(parent!=x[0])
            {
                if(x[1]==1)
                    cost[x[0]]=cost[curr]-1;
                else
                    cost[x[0]]=cost[curr]+1;
                helper(x[0],curr,cost,map);
            }
        }
    }
    public int[] minEdgeReversals(int n, int[][] edges) {
        List<int[]> map[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new ArrayList<>();
        }
        for(int[] x:edges)
        {
            map[x[0]].add(new int[]{x[1],0});
            map[x[1]].add(new int[]{x[0],1});
        }
        int cost[]=new int[n];
        cost[0]=dfs(0,-1,map);
        helper(0,-1,cost,map);
        return cost;
    }
}