class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length;
        int rowzeros[]=new int[n];
        int colzeros[]=new int[m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==0)
                {
                    rowzeros[i]=1;
                    colzeros[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(rowzeros[i]==1)
            {
                for(int j=0;j<m;j++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            if(colzeros[i]==1)
            {
                for(int j=0;j<n;j++)
                {
                    matrix[j][i]=0;
                }
            }
        }
    }
}