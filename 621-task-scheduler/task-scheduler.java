class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) 
            return tasks.length;
        int c[]=new int[26];
        for(char ch:tasks)
            c[ch-'A']++;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<26;i++)
        {
            if(c[i]>0)
                pq.add(c[i]);
        }
        Queue<List<Integer>> q=new LinkedList<>();  //waiting time,data
        int time=0;
        while(!pq.isEmpty() || !q.isEmpty())
        {
            if(pq.isEmpty())
            {
                time=q.peek().get(0);
                // pq.add(q.poll().get(1));
            }
            while(!q.isEmpty() && q.peek().get(0)<=time)
            {
                pq.add(q.poll().get(1));
            }
            int cur=pq.poll();
            if(cur!=1)
                q.add(Arrays.asList(time+n+1,cur-1));
            time++;
        }
        return time;
    }
}