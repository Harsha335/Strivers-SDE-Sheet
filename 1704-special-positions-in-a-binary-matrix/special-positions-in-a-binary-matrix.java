class Solution {
    public int numSpecial(int[][] mat) {
        int n=mat.length,m=mat[0].length;
        int rowCounter[]=new int[n];
        int cols[]=new int[m];
        Arrays.fill(cols,-1);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                    rowCounter[i]+=1;
                    if(cols[j]==-1)
                        cols[j]=i;
                    else
                        cols[j]=-2;
                }
            }
        }
        int count=0;
        for(int i=0;i<m;i++)
        {
            if(cols[i]>=0)
            {
                if(rowCounter[cols[i]]==1)
                    count++;
            }
        }
        return count;
    }
}