class Solution {
    class Union{
        int n;
        int parent[];
        int rank[];
        Union(int n)
        {
            this.n=n;
            parent=new int[n];
            for(int i=0;i<n;i++)
            {
                parent[i]=i;
            }
            rank=new int[n];
            Arrays.fill(rank,1);
        }
        int findParent(int ele)
        {
            if(ele==parent[ele]) 
                return ele;
            return parent[ele]=findParent(parent[ele]);
        }
        boolean union(int ele1,int ele2)
        {
            int p1=findParent(ele1);
            int p2=findParent(ele2);
            if(p1==p2) return false;
            if(rank[p1]>rank[p2])
            {
                parent[p2]=p1;
                rank[p1]+=rank[p2];
            }
            else{
                parent[p1]=p2;
                rank[p2]+=rank[p1];
            }
            return true;
        }
    }
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n=vals.length;
        List<Integer> map[]=new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new ArrayList<>();
        }
        for(int[] x:edges)
        {
            map[x[0]].add(x[1]);
            map[x[1]].add(x[0]);
        }
        TreeMap<Integer,List<Integer>> values=new TreeMap<>();
        for(int i=0;i<n;i++)
        {
            values.putIfAbsent(vals[i],new ArrayList<>());
            values.get(vals[i]).add(i);
        }
        Union dsu=new Union(n);
        int output=0;
        for(int value:values.keySet())
        {
            for(int ele:values.get(value))
            {
                for(int x:map[ele])
                {
                    if(value>=vals[x])    //add smaller vals edges
                        dsu.union(ele,x);
                }
            }
            //find different clusters with number of value-vals
            HashMap<Integer,Integer> grouped=new HashMap<>();//parent,count
            for(int ele:values.get(value))
            {
                grouped.put(dsu.findParent(ele),grouped.getOrDefault(dsu.findParent(ele),0)+1);
            }
            for(int key:grouped.keySet())
            {
                int size=grouped.get(key);
                output+=(size*(size+1))/2;
            }
        }
        return output;
    }
}