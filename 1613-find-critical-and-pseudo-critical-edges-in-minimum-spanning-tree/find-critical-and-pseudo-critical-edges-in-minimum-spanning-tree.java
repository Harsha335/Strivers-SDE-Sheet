class Solution {
    class DSU{
        int parent[];
        int rank[];
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
        }
        int findParent(int ele)
        {
            if(parent[ele]==ele)
            {
                return ele;
            }
            return parent[ele]=findParent(parent[ele]);
        }
        boolean union(int ele1,int ele2)
        {
            int p1=findParent(ele1);
            int p2=findParent(ele2);
            if(p1!=p2)
            {
                if(rank[p1]<rank[p2])
                {
                    parent[p1]=p2;
                    rank[p2]+=rank[p1];
                }   
                else{
                    parent[p2]=p1;
                    rank[p1]+=rank[p2];
                }
                return true;
            }
            return false;
        }
    }
    List<List<Integer>> edge;
    int mst(int n,int len,int include,int exclude)
    {
        DSU dsu=new DSU(n);
        int weight=0;
        if(include!=-1)
        {
            weight+=edge.get(include).get(2);
            dsu.union(edge.get(include).get(0),edge.get(include).get(1));
        }
        for(int i=0;i<len;i++)
        {
            if(include==i || exclude==i)continue;
            if(dsu.union(edge.get(i).get(0),edge.get(i).get(1)))
                weight+=edge.get(i).get(2);
        }
        for(int i=0;i<n;i++)
        {
            // System.out.print(dsu.parent[i]+" ");
            if(dsu.findParent(i)!=dsu.parent[0]){
                return (int)1e9;
            }
        }
            // System.out.println();
        return weight;
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        edge=new ArrayList<>();
        int len=edges.length;
        for(int i=0;i<len;i++)
        {
            edge.add(Arrays.asList(edges[i][0],edges[i][1],edges[i][2],i));
        }
        Collections.sort(edge,(a,b)->a.get(2)-b.get(2));
        // System.out.println(edge);
        int minMST=mst(n,len,-1,-1);
        List<List<Integer>> output=new ArrayList<>();
        output.add(new ArrayList<>());
        output.add(new ArrayList<>());
        for(int i=0;i<len;i++)
        {
            if(minMST<mst(n,len,-1,i))
            {
                output.get(0).add(edge.get(i).get(3));
            }
            else if(mst(n,len,i,-1)==minMST)
            {
                output.get(1).add(edge.get(i).get(3));
            }
        }
        return output;
    }
}