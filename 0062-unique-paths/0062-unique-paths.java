class Solution {
    int cache[][];
    public int helper(int i,int j,int n,int m)
    {
        if(i<0 || j<0 || i==n || j==m)return 0;
        if(i==n-1 && j==m-1)return 1;
        if(cache[i][j]!=-1)return cache[i][j];
        return cache[i][j]=helper(i+1,j,n,m)+helper(i,j+1,n,m);
    }
    public int uniquePaths(int m, int n) {
        cache=new int[m][n];
        for(int[] x:cache)
        {
            Arrays.fill(x,-1);
        }
        return helper(0,0,m,n);
    }
}