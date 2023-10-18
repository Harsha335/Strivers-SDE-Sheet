class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
            return Arrays.asList(0);
        int indegree[]=new int[n];
        List<Integer>  adj[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adj[i]=new ArrayList<>();
        }
        for(int x[]:edges)
        {
            adj[x[0]].add(x[1]);
            adj[x[1]].add(x[0]);
            indegree[x[0]]++;
            indegree[x[1]]++;
        }
        List<Integer> leafs=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==1)
            {
                leafs.add(i);
            }
        }
        while(n>2)
        {
            n-=leafs.size();
            int size=leafs.size();
            while(size-->0)
            {
                int curr=leafs.remove(size);
                int adjacent=adj[curr].get(0);
                adj[adjacent].remove(Integer.valueOf(curr));//only one exits
                indegree[adjacent]--;
                if(indegree[adjacent]==1)
                {
                    leafs.add(adjacent);
                }
            }
        }
        return leafs;
    }
}