class Solution {
    public int minimumTime(int n, int[][] rel, int[] time) {
        List<Integer> adj[] = new ArrayList[n+1];
        for(int i=0;i<n+1;i++){
            adj[i] = new ArrayList<>();
        }
        int incom[] = new int[n+1];
        for(int i=0;i<rel.length;i++){
            adj[rel[i][1]].add(rel[i][0]);
            incom[rel[i][0]]++;
        }
        for(int i=1;i<n+1;i++){
            if(incom[i]==0){
                adj[0].add(i);
            }
        }
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return dfs(adj,0,time,dp);
    }
    public int dfs(List<Integer> adj[],int node,int []time,int dp[]){
        if(dp[node]!=-1) return dp[node];
        int max = 0;
        for(int i:adj[node]){
            max = Math.max(time[i-1]+dfs(adj,i,time,dp),max);
        }
        return dp[node] = max;
    }
}