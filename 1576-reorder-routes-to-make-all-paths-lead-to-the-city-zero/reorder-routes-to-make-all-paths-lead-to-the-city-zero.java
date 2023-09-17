class Solution {
    int dfs(int ele,int parent,List<int[]> map[])
    {
        int ans=0;
        for(int[] x:map[ele])
        {
            if(x[0]!=parent)
                ans+=x[1]+dfs(x[0],ele,map);
        }
        return ans;
    }
    public int minReorder(int n, int[][] connections) {
        List<int[]> map[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new ArrayList<>();//destination cost
        }
        for(int[] x:connections)
        {
            map[x[0]].add(new int[]{x[1],0});//0 penality
            map[x[1]].add(new int[]{x[0],1});//1 penality
        }
        return (n-1)-dfs(0,-1,map);
    }
}