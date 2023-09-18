class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
        // int row[][]=new int[n][2];//value and time(latest)
        // int col[][]=new int[n][2];
        // int time=0;//index
        // for(int x[]:queries)
        // {
        //     if(x[0]==0)
        //     {
        //         row[x[1]][0]=x[2];
        //         row[x[1]][1]=time;
        //     }
        //     else{
        //         // System.out.println(x[1]);
        //         col[x[1]][0]=x[2];
        //         col[x[1]][1]=time;
        //     }
        //     time++;
        // }
        // long output=0;
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //     {
                
        //         if(row[i][1]>col[j][1])
        //         {
        //             output+=row[i][0];
        //         }
        //         else if(row[i][1]==col[j][1])
        //             output+=Math.max(row[i][0],col[j][0]);
        //         else
        //             output+=col[j][0];
        //     }
        // }
        // return output;
        HashSet<Integer> rows=new HashSet<>();
        int rowSize=0;
        HashSet<Integer> cols=new HashSet<>();
        int colSize=0;
        long output=0;
        int q=queries.length-1;
        for(;q>=0;q--)
        {
            int[] x=queries[q];
            if(x[0]==0 && !rows.contains(x[1]))
            {
                output+=(x[2]*(n-colSize));
                rows.add(x[1]);
                rowSize++;
            }
            else if(x[0]==1 && !cols.contains(x[1]))
            {
                output+=(x[2]*(n-rowSize));
                cols.add(x[1]);
                colSize++;
            }
            if(rowSize==colSize && rowSize==n)
                return output;
        }
        return output;
    }
}