class Solution {
    int n,m;
    // private int getValue(int img[][],int i, int j)
    // {
        
    // }
    public int[][] imageSmoother(int[][] img) {
        n=img.length;m=img[0].length;
        int output[][]=new int[n][m];
        int dir[][]=new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                int sum=0;
                int count=9;
                for(int x[]:dir)
                {
                    if(x[0]+i<0 || x[1]+j<0 || x[0]+i>=n || x[1]+j>=m)
                        count--;
                    else
                        sum+=img[x[0]+i][x[1]+j];
                }
                // System.out.println(sum+" "+count);
                output[i][j]=sum/count;
            }
        }
        return output;
    }
}