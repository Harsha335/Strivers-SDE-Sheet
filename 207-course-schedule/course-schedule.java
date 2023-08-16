class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<Integer> arr[]=new ArrayList[n];
        int count[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new ArrayList<>();
        }
        for(int x[]:pre)
        {
            arr[x[1]].add(x[0]);
            count[x[0]]++;
        }
        Queue<Integer> topo=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(count[i]==0)
                topo.add(i);
        }
        int topoCount=0;
        while(!topo.isEmpty())
        {
            int cur=topo.poll();
            topoCount+=1;
            for(int x:arr[cur])
            {
                count[x]-=1;
                if(count[x]==0) topo.add(x);
            }
        }
        return topoCount==n;
    }
}