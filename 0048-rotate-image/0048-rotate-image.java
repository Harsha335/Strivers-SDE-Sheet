class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int length=n;
        for(int i=0;i<=n/2;i++)
        {
            // System.out.println(i);
            for(int j=i;j<length-1;j++)
            {
                // System.out.println(j+" :");
                // System.out.println(i+" "+j+" "+(n-i-1)+" "+(n-j-1));
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][i];
                matrix[n-j-1][i]=matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1]=matrix[j][n-i-1];
                matrix[j][n-i-1]=temp;
            }
            length-=1;
        }
    }
}