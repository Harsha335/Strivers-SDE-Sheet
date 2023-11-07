class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> pq=new PriorityQueue<>();
        int n=dist.length;
        for(int i=0;i<n;i++)
        {
            pq.add((double)dist[i]/speed[i]);
        } 
        if(pq.peek()==0)
            return 1;
        int count=0;
        while(!pq.isEmpty())
        {
            double curr=pq.poll();
            // System.out.println(curr);
            if(curr<=count)
            {
                break;
            }
            count++;
        }
        return count;
    }
}