class Solution {
    int helper(int ind,int parent,List<Integer> map[],List<Boolean> hasApple)
    {
        int ans=0;
        for(int x:map[ind])
        {
            if(parent==x) continue;
            int curr=helper(x,ind,map,hasApple);
            if(hasApple.get(x) || curr!=0)
            {
                curr+=2;
            }
            ans+=curr;
        }
        return ans;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<Integer> map[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new ArrayList<>();
        }
        int e=edges.length;
        for(int i=0;i<e;i++)
        {
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
        }
        return helper(0,-1,map,hasApple);
    }
}