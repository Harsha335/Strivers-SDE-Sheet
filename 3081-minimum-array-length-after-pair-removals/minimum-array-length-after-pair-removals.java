class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int pre=-1,count=0;
        for(int x:nums)
        {
            if(pre==x || pre==-1)
            {
                pre=x;
                count++;
            }
            else{
                pq.add(count);
                count=1;
                pre=x;
            }
        }
        pq.add(count);
        // System.out.println(pq);
        while(pq.size()>1)
        {
            int p1=pq.poll();
            int p2=pq.poll();
            p1-=1;
            p2-=1;
            if(p1>0)pq.add(p1);
            if(p2>0)pq.add(p2);
        }
        return pq.isEmpty()?0:pq.poll();
    }
}