class Solution {
    Stack<Integer> topo;
    void dfs(int[] edges,int ind,boolean visited[])
    {
        if(ind==-1) return;
        if(visited[ind]) return;
        visited[ind]=true;
        dfs(edges,edges[ind],visited);
        topo.push(ind);
    }
    int revDfs(HashMap<Integer,List<Integer>> revMap,int ind,boolean visited[])
    {
        visited[ind]=true;
        if(!revMap.containsKey(ind)) return 1;
        int ans=0;
        // if(visited[ind]) return 0;
        for(int x:revMap.get(ind))
        {
            if(!visited[x])
            {

                ans+=revDfs(revMap,x,visited);
            // System.out.println(x+" "+ans);
            }

        }
        return ans+1;
    }
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean visited[]=new boolean[n];
        topo=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(edges,i,visited);
            }
        }
        HashMap<Integer,List<Integer>> revMap=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            revMap.putIfAbsent(edges[i],new ArrayList<>());
            revMap.get(edges[i]).add(i);
        }
        int output=-1;
        // System.out.println(topo);
        Arrays.fill(visited,false);
        while(!topo.isEmpty())
        {
            int x=topo.pop();
            if(!visited[x])
            {
                int out=revDfs(revMap,x,visited);
                // System.out.println(x+"-"+out);
                if(out!=1)
                    output=Math.max(output,out);
            }
        }
        return output;
    }
}