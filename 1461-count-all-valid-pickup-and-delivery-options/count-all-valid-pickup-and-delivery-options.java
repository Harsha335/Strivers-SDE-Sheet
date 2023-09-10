class Solution {
    long map[][];
    int mod=(int)1e9+7;
    long helper(int i,int j,int n)
    {
        if(i==0 && j==0)return 1;
        if(map[i][j]!=0)
            return map[i][j];
        long ans=0;
        //deliver
        if((n-i)>(n-j))
        {
            ans=(j-i)*(helper(i,j-1,n));
        }
        ans=(ans%mod);
        //pickup
        if(i>0)
        {
            ans+=i*(helper(i-1,j,n));
        }
        return map[i][j]=(ans%mod);
    }
    public int countOrders(int n) {
        map=new long[n+1][n+1];
        // for(long[] x:map)
        // {
        //     Arrays.fill(x,-1);
        // }
        return (int)helper(n,n,n);
    }
}