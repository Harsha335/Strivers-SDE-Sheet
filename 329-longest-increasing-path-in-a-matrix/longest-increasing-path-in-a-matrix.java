class Solution {
    int dir[][]=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};
    int n;
    int m;
    int helper(int[][] matrix,int[][] counter,int i,int j)
    {
        // System.out.println(i+" "+j+" "+counter[i][j]);
        if(counter[i][j]!=0) 
            return counter[i][j];
        int ans=0;
        for(int[] d:dir)
        {
            int x=i+d[0];
            int y=j+d[1];
            if(x>=0 && y>=0 && x<n && y<m && matrix[x][y]>matrix[i][j])
            {
                ans=Math.max(ans,1+helper(matrix,counter,x,y));
            }
        }
        counter[i][j]=ans;
        return ans;
    }
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;
        int counter[][]=new int[n][m];
        int output=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(counter[i][j]==0)
                {
                    helper(matrix,counter,i,j);
                }
                // System.out.println(i+" "+j+" "+counter[i][j]);
                output=Math.max(output,counter[i][j]+1);
            }
        }
        return output;
    }
}