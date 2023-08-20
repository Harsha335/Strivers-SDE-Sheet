class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int gCount[]=new int[m+1];
        int count[]=new int[n];
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        map.put(-1,new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            map.putIfAbsent(i,new ArrayList<>());

            map.putIfAbsent(group[i],new ArrayList<>());
            map.get(group[i]).add(i);
        }
        // System.out.println("map "+map);
        HashMap<Integer,List<Integer>> before=new HashMap<>();
        for(int x:map.keySet())
        {
            for(int ele:map.get(x))
            {
                for(int bi:beforeItems.get(ele))
                {
                    if(!map.get(x).contains(bi))
                    {
                        gCount[x+1]++;
                    }
                    count[ele]++;
                    before.putIfAbsent(bi,new ArrayList<>());
                    before.get(bi).add(ele);    //6->1,3,4
                }
            }
        }
        // System.out.println("before "+before);
        Queue<Integer> readyGrp=new LinkedList<>();
        int[] output=new int[n];
        boolean visited[]=new boolean[n];
        int ind=0;
        readyGrp.add(-1);   //add compolsory
        for(int i=0;i<m;i++)
        {
            if(gCount[i+1]==0)
            {
                readyGrp.add(i);
            }
        }
        // System.out.println("output"+ind);
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(output[i]+" ");
        // }
        // System.out.println();
        // System.out.println("readyGrp "+readyGrp);
        while(!readyGrp.isEmpty())
        {
            int grp=readyGrp.poll();
            Queue<Integer> readyEle=new LinkedList<>();
            // System.out.println(grp);
            for(int x:map.get(grp))
            {
                if(count[x]==0)
                {
                    readyEle.add(x);
                }
            }
            // System.out.println(grp+" "+readyEle);
            while(!readyEle.isEmpty())
            {
                int ele=readyEle.poll();
                // System.out.println(ele);
                if(!visited[ele])
                    output[ind++]=ele;
                visited[ele]=true;
                if(before.containsKey(ele))
                    for(int x:before.get(ele))
                    {
                        count[x]-=1;
                        if(gCount[group[x]+1]!=0 && group[x]!=grp)
                        {
                            gCount[group[x]+1]-=1;
                            if(gCount[group[x]+1]==0) readyGrp.add(group[x]);
                        }
                        // System.out.println(x+" "+count[x]+" "+gCount[group[x]+1]+" "+readyGrp);
                        if(count[x]==0 && group[x]==grp)
                        {
                            readyEle.add(x);
                        }
                    }
            }
        }
        // System.out.println("output"+ind);
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(output[i]+" ");
        // }
        // System.out.println();
        if(ind!=n) return new int[]{};
        return output;
    }
}