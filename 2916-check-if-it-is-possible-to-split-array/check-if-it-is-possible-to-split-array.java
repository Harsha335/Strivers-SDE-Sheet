class Solution {
    int prefixSum[];
    int dp[][];
    boolean helper(List<Integer> nums,int m,int low,int high)
    {
        // System.out.println(low+" "+high);
        if(low>=high) return true;
        if(dp[low][high]!=-1) return dp[low][high]==1?true:false;
        for(int i=low+1;i<=high;i++)
        {
        // System.out.println(((i-low)==1)+" "+(prefixSum[i]-prefixSum[low]>=m));
        // System.out.println((high==i)+" "+(prefixSum[high+1]-prefixSum[i]>=m));
            if(((i-low)==1 || prefixSum[i]-prefixSum[low]>=m) && (high==i || prefixSum[high+1]-prefixSum[i]>=m))
            {
                if(helper(nums,m,low,i-1) && helper(nums,m,i,high)) {
                    dp[low][high]=1;
                    return true;
                }
            }
        }
        dp[low][high]=0;
        return false;
    }
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n=nums.size();
        prefixSum=new int[n+1];
        prefixSum[0]=0;
        for(int i=1;i<=n;i++)
        {
            prefixSum[i]=prefixSum[i-1]+nums.get(i-1);
        }
        dp=new int[n][n];
        for(int[] x:dp)  Arrays.fill(x,-1);
        return helper(nums,m,0,n-1);
    }
}