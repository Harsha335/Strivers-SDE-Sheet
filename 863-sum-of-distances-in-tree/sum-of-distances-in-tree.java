class Solution {
    List<Integer> map[];
    int countChild[];//include itself
    int dfs(int curr,int parent)
    {
        int ans=1;
        for(int child:map[curr])
        {
            if(child!=parent)
            {
                ans+=dfs(child,curr);
            }
        }
        countChild[curr]=ans;
        return ans;
    }
    // int firstAns()
    void ans(int parentValue,int curr,int parent,int output[],int n)
    {
        if(parent!=-1)
            output[curr]=parentValue-countChild[curr]+(n-countChild[curr]);
        for(int child:map[curr])
        {
            if(child!=parent)
            {
                ans(output[curr],child,curr,output,n);
            }
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        map=new ArrayList[n];
        countChild=new int[n];
        for(int i=0;i<n;i++)
        {
            map[i]=new ArrayList<>();
        }
        for(int[] x:edges)
        {
            map[x[0]].add(x[1]);
            map[x[1]].add(x[0]);
        }
        dfs(0,-1);
        int output[]=new int[n];
        // output[0]=firstAns(0,-1);
        for(int i=1;i<n;i++)
        {
            output[0]+=countChild[i];
        }
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(countChild[i]+" ");
        // }
        // System.out.println(output[0]);
        ans(output[0],0,-1,output,n);
        return output;
    }
}