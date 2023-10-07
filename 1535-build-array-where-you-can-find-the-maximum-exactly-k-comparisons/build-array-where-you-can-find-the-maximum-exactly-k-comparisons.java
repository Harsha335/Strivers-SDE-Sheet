class Solution {
    int mod=(int)1e9+7;
    int[][][] dp;
    // int power(int x, int y, int p)
    // {
    //     int res = 1; // Initialize result
    
    //     x = x % p; // Update x if it is more than or
    //     // equal to p
    
    //     if (x == 0)
    //     return 0; // In case x is divisible by p;
    
    //     while (y > 0)
    //     {
    
    //     // If y is odd, multiply x with result
    //     if ((y & 1) != 0)
    //         res = (res * x) % p;
    
    //     // y must be even now
    //     y = y >> 1; // y = y/2
    //     x = (x * x) % p;
    //     }
    //     return res;
    // }
    // int power(int num,int k)
    // {
    //     if(k==0)
    //         return 1;
    //     if(k==1)
    //         return num;
    //     int value=power(num,k/2);
    //     return (((value*value)%mod)*(k%2==0?1:num))%mod;
    // }
    int helper(int n,int m,int k,int preMax)
    {
        if(k<0)
            return 0;
        if(n==0)
        {
            if(k==0)return 1;
            return 0;
        }
        if(dp[n][k][preMax]!=-1)
            return dp[n][k][preMax];
        // if(k==0)
        // {
        //     return power(preMax,n,mod)%mod;
        // }
        int output=0;
        for(int i=1;i<=m;i++)
        {
            if(preMax<i)
            {
                output=(output+helper(n-1,m,k-1,i))%mod;
            }
            else{
                output=(output+helper(n-1,m,k,preMax))%mod;
            }
        }
        return dp[n][k][preMax]=output;
    }
    public int numOfArrays(int n, int m, int k) {
        dp=new int[n+1][k+1][m+1];
        for(int d[][]:dp)
        {
            for(int x[]:d)
                Arrays.fill(x,-1);
        }
        return helper(n,m,k,0);
    }
}