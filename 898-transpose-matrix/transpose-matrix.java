class Solution {
    public int[][] transpose(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        // int i=0,j=m-1;
        // while(i<j)
        // {
        //     for(int k=0;k<n;k++)
        //     {
        //         int temp=matrix[i][k];
        //         matrix[i][k]=matrix[j][k];
        //         matrix[j][k]=temp;
        //     }
        //     i++;
        //     j--;
        // }
        int output[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                output[i][j]=matrix[j][i];
            }
        }
        return output;
    }
}