class Solution {
    private int dp[][];
    private int helper(int arr[],int i,int d)
    {
        // System.out.println(i+" "+d);
        if(i == -1)
            return 0;
        if(d == 0)
            return (int)1e9;
        if(dp[i][d] != -1)
            return dp[i][d];
        int maxi = 0;
        int ans = (int)1e9;
        for(int k = i;k>=d-1;k--)
        {
            maxi = Math.max(maxi,arr[k]);
            // System.out.println(maxi);
            ans = Math.min(ans,maxi+helper(arr,k-1,d-1));
            // System.out.println(ans+"--");
        }
        return dp[i][d] = ans;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n < d)
            return -1;
        dp=new int[n][d+1];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(jobDifficulty,n-1,d);
    }
}