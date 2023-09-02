class Solution {
    int totalVisit;
    // int[][] dp;
    HashMap<List<Integer>,Integer> dp;
    int msb(int num)
    {
        return 31-Integer.numberOfLeadingZeros(num);
    }
    int helper(int[] outEdges,int[] indegree,int n,int k,int visited,int avail)
    {
        if(visited==totalVisit) 
            return 0;
                // System.out.println(visited+" "+avail);
        // if(dp[visited][avail]!=-1) return dp[visited][avail];
        List<Integer> curr=Arrays.asList(visited,avail);
        if(dp.containsKey(curr))
            return dp.get(curr);
        int output=(int)1e9;
        for(int sub=avail;sub>0;sub=(sub-1)&avail)
        {
            if(((sub==avail) && (Integer.bitCount(sub)<=k)) || Integer.bitCount(sub)==k)
            {
                // System.out.println("sub-"+Integer.toBinaryString(sub));
                int tempAvail=sub;
                // visited|=avail;
                int newAvail=0;
                while(tempAvail!=0)
                {
                    int ele=msb(tempAvail);
                    // System.out.println(ele);
                    int val=outEdges[ele];
                    // for(int x:outEdges[ele])
                    while(val!=0)
                    {
                        int x=msb(val);
                        indegree[x]--;
                        if(indegree[x]==0)  
                            newAvail|=(1<<x);
                        val^=(1<<x);
                    }
                    tempAvail^=(1<<ele);
                    // System.out.println(Integer.toBinaryString(tempAvail));
                }
                // System.out.println(indegree[4]+" "+indegree[7]+" "+indegree[8]);
                // System.out.println("new "+Integer.toBinaryString(newAvail));
                output=Math.min(1+helper(outEdges,indegree,n,k,(visited|sub),((newAvail)|(sub^avail)) ),output);
                tempAvail=sub;
                while(tempAvail!=0)
                {
                    int ele=msb(tempAvail);
                    // System.out.println(ele);
                    int val=outEdges[ele];
                    // for(int x:outEdges[ele])
                    while(val!=0)
                    {
                        int x=msb(val);
                        indegree[x]++;
                        val^=(1<<x);
                    }
                    tempAvail^=(1<<ele);
                    // System.out.println(Integer.toBinaryString(tempAvail));
                }
            }
            if((sub==avail) && (Integer.bitCount(sub)<=k))
                break;
        }
        dp.put(curr,output);
        return output;
    }
    public int minNumberOfSemesters(int n, int[][] relations, int k) {
        //toposort
        totalVisit=(1<<(n+1))-1;
        // dp=new int[(1<<(n+1))][1<<(n+1)];
        dp=new HashMap<>();
        // for(int x[]:dp)
        // {
        //     Arrays.fill(x,-1);
        // }
        // List<Integer> outEdges[]=new ArrayList[n+1];
        int outEdges[]=new int[n+1];
        int indegree[]=new int[n+1];
        // for(int i=0;i<=n;i++)
        // {
        //     outEdges[i]=new ArrayList<>();
        // }
        for(int x[]:relations)
        {
            // outEdges[x[0]].add(x[1]);
            outEdges[x[0]]|=(1<<x[1]);
            indegree[x[1]]++;
        }
        int available=0;
        for(int i=1;i<=n;i++)
        {
            // System.out.println(i+" "+Integer.toBinaryString(outEdges[i])+" "+indegree[i]);
            if(indegree[i]==0)
            {
                available|=(1<<i);  //add available
            }
        }
        // System.out.println(available+" "+Integer.toString(available,2));
        return helper(outEdges,indegree,n,k,1,available);
    }
}

// 4
// [[2,1],[3,1],[1,4]]
// 2
// 5
// [[2,1],[3,1],[4,1],[1,5]]
// 2
// 12
// [[1,2],[1,3],[7,5],[7,6],[4,8],[8,9],[9,10],[10,11],[11,12]]
// 2

// 13
// [[12,8],[2,4],[3,7],[6,8],[11,8],[9,4],[9,7],[12,4],[11,4],[6,4],[1,4],[10,7],[10,4],[1,7],[1,8],[2,7],[8,4],[10,8],[12,7],[5,4],[3,4],[11,7],[7,4],[13,4],[9,8],[13,8]]
// 9