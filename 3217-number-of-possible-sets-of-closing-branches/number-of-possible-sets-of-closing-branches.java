class Solution {
    private int helper(int mask,int graph[][],int maxDist,int n)
    {
        int temp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                temp[i][j]=graph[i][j];
            }
        }
        for(int k=0;k<n;k++)
        {
            if((mask&(1<<k))==0)
                continue;
            for(int i=0;i<n;i++)
            {
                if((mask&(1<<i))==0)
                    continue;
                for(int j=0;j<n;j++)
                {
                    if((mask&(1<<j))==0)
                        continue;
                    temp[i][j]=Math.min(temp[i][j],temp[i][k]+temp[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if((mask&(1<<i))==0)
                continue;
            for(int j=i+1;j<n;j++)
            {
                if((mask&(1<<j))==0)
                    continue;
                if(temp[i][j]>maxDist)
                    return 0;
            }
        }
        return 1;
    }
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int graph[][]=new int[n][n];
        for(int x[]:graph)
        {
            Arrays.fill(x,(int)1e5);
        }
        for(int i=0;i<n;i++)
        {
            graph[i][i]=0;
        }
        for(int[] road:roads)
        {
            int a=road[0],b=road[1],dist=road[2];
            graph[a][b]=Math.min(graph[a][b],dist);
            graph[b][a]=Math.min(graph[b][a],dist);
        }
        int mask=1<<n;
        int output=1;
        for(int i=1;i<mask;i++)
        {
            output+=helper(i,graph,maxDistance,n);
        }
        return output;
    }
}