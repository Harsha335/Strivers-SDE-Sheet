class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(matrix[i][j]==1)
                    matrix[i][j]=matrix[i-1][j]+1;
            }
        }
        int output=0;
        for(int arr[]:matrix)
        {
            Arrays.sort(arr);
            for(int i=m-1;i>=0;i--)
            {
                output=Math.max(output,arr[i]*(m-i));
            }
        }
        return output;
    }
}