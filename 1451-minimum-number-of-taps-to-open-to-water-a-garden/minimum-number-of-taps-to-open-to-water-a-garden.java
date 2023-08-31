class Solution {
    public int minTaps(int n, int[] ranges) {
        int start=0,end=0;
        // int left[]=new int[n+1];
        // int right[]=new int[n+1];
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        for(int i=0;i<=n;i++)
        {
            int left=Math.max(0,i-ranges[i]);
            int right=i+ranges[i];
            pq.add(Arrays.asList(left,right));
            // System.out.println(i+" "+left[i]+" "+right[i]);
        }
        int count=0;
        while(!pq.isEmpty())
        {
            int left=pq.peek().get(0);
            int right=pq.peek().get(1);
            pq.poll();
        // System.out.println(pq.poll());
            if(left<=start)
            {
                end=Math.max(end,right);
            }
            else{
        // System.out.println(end);
                start=end;
                count++;
                if(left>end)
                    return -1;//cannot make
                end=Math.max(end,right);
                if(start>=n)
                    return count;
            }
        }
        if(end<n) return -1;
        return count+1;
    }
}