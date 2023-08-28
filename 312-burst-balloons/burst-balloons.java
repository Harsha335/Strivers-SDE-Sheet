class Solution {
    int n;
    int dp[][];
    int matrixChainMultiply(int[] nums,int i,int j)
    {
        if(i>j) return 0;
        if(i==j)
        {
            return nums[i]*(i==0?1:nums[i-1])*(j==n-1?1:nums[j+1]);
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int output=0;
        for(int k=i;k<=j;k++)
        {
            int curr=nums[k]*(i==0?1:nums[i-1])*(j==n-1?1:nums[j+1]);
            curr+=matrixChainMultiply(nums,i,k-1);
            curr+=matrixChainMultiply(nums,k+1,j);
            output=Math.max(output,curr);
        }
        return dp[i][j]=output;
    }
    public int maxCoins(int[] nums) {
        n=nums.length;
        dp=new int[n][n];
        for(int x[]:dp)
        {
            Arrays.fill(x,-1);
        }
        return matrixChainMultiply(nums,0,n-1);
    }
}