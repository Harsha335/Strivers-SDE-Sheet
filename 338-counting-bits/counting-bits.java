class Solution {
    // int findBits(int num)
    // {   // Nlog(num)
    //     int count=0;
    //     while(num>0)
    //     {
    //         if(num%2!=0)
    //             count++;
    //         num>>=1;
    //     }
    //     return count;
    // }
    public int[] countBits(int n) {
        // int output[]=new int[n+1];
        // for(int i=0;i<=n;i++)
        // {
        //     output[i]=findBits(i);
        // }
        // return output;

        int dp[]=new int[n+1];
        int start=0;
        int end=1;
        while(end<=n)
        {
            while(start<end && start+end<=n)
            {
                dp[start+end]=dp[start]+1;
                start++;
            }
            start=0;
            end<<=1;
        }
        return dp;
    }
}