class Solution {
    public int maximalNetworkRank(int n, int[][] road) {
        HashSet<Integer> map[]=new HashSet[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new HashSet<>();
        }
        int m=road.length;
        for(int i=0;i<m;i++)
        {
            map[road[i][0]].add(road[i][1]);
            map[road[i][1]].add(road[i][0]);
        }
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->{return -a.get(0)+b.get(0);});
        for(int i=0;i<n;i++)
        {
            pq.add(Arrays.asList(map[i].size(),i));
        }
        // System.out.println(pq);
        List<Integer> a1=pq.poll();
        List<Integer> a2=pq.poll();
        if(!map[a1.get(1)].contains(a2.get(1))) return a1.get(0)+a2.get(0);
        int ans=a1.get(0)+a2.get(0)-1;
        List<List<Integer>> check=new ArrayList<>();
        check.add(a1);
        check.add(a2);
        while(!pq.isEmpty())
        {
            check.add(pq.poll());
        }
        // if(!pq.isEmpty())
        // {
        //     check.add(pq.poll());
        // }
        m=check.size();
        for(int i=0;i<m;i++)
        {
            List<Integer> l1=check.get(i);
            for(int j=i+1;j<m;j++)
            {
                List<Integer> l2=check.get(j);
                if(map[l1.get(1)].contains(l2.get(1)))
                {
                    ans=Math.max(ans,l1.get(0)+l2.get(0)-1);
                }
                else
                    ans=Math.max(ans,l1.get(0)+l2.get(0));
            }
        }
        return ans;
    }
}