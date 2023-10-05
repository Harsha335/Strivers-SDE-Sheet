class Solution {
    int n;
    int dp[][];
    int helper(int[] nums,int ind,int rem)
    {
        if(ind==n)
        {
            if(rem==0)  return 0;
            return -(int)1e5;
        }
        if(dp[ind][rem]!=-1)
            return dp[ind][rem];
        int pick=helper(nums,ind+1,(rem+nums[ind])%3)+nums[ind];
        int notpick=helper(nums,ind+1,rem);
        return dp[ind][rem]=Math.max(pick,notpick);
    }
    public int maxSumDivThree(int[] nums) {
        n=nums.length;
        dp=new int[n][3];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(nums,0,0);
    }
}