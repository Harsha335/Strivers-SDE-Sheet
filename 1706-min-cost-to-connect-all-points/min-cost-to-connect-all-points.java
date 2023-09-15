class Solution {
    HashMap<List<Integer>,Integer> index;
    int[] parent;
    int[] countChild;
    int parent(int i)
    {
        if(i==parent[i])return i;
        return parent[i]=parent(parent[i]);
    }
    void union(int p1,int p2)
    {
        if(countChild[p1]>=countChild[p2])
        {
            parent[p2]=p1;
            countChild[p1]+=countChild[p2];
        }
        else{
            parent[p1]=p2;
            countChild[p2]+=countChild[p1];
        }
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->a.get(4)-b.get(4));
        int n=points.length;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)continue;
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                pq.add(Arrays.asList(x1,y1,x2,y2,Math.abs(x1-x2)+Math.abs(y1-y2)));
            }
        }
        // System.out.println(pq);
        int ind=0;
        index=new HashMap<>();
        for(int[] x:points)
        {
            index.put(Arrays.asList(x[0],x[1]),ind++);
        }
        // System.out.println(index);
        int count=0;//adj formed
        int output=0;
        parent=new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i]=i;
        }
        countChild=new int[n];
        while(count!=n-1)
        {
            List<Integer> cur=pq.poll();
            int index1=index.get(cur.subList(0,2));
            int index2=index.get(cur.subList(2,4));
            // System.out.println(cur);
            // System.out.println(index1+"-"+index2);
            int parent1=parent(index1);
            int parent2=parent(index2);
            // System.out.println(parent1+"-"+parent2);
            if(parent1!=parent2)
            {
                count++;
                output+=cur.get(4);
                union(parent1,parent2);
            }
        }
        return output;
    }
}