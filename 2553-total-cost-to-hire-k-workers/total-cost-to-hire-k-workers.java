class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n=costs.length;
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        int i;
        for(i=0;i<n && i<candidates;i++)
        {
            pq1.add(costs[i]);
        }
        int end1=i;
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        for(i=n-1;i>=0 && i>=candidates && (n-i)<=candidates;i--)
        {
            pq2.add(costs[i]);
        }
        // System.out.println(pq1+" "+pq2);
        int end2=i;
        // System.out.println(end1+" "+end2);
        long cost=0;
        while(k-->0)
        {
            int min1=(int)1e9;
            if(!pq1.isEmpty())
                min1=pq1.peek();
            int min2=(int)1e9;
            if(!pq2.isEmpty())
                min2=pq2.peek();
            // System.out.println(min1+" "+min2);
            if(min1<=min2)
            {
                cost+=pq1.poll();
                if(end1<=end2)
                {
                    pq1.add(costs[end1]);
                    end1++;
                }
            }
            else{
                cost+=pq2.poll();
                if(end1<=end2)
                {
                    pq2.add(costs[end2]);
                    end2--;
                }
            }
        // System.out.println(pq1+" "+pq2);
        }
        return cost;
    }
}