class Solution {
    int dp[];
    boolean helper(int []nums,int ind,int n)
    {
        // System.out.println(ind);
        if(ind==n) return true;
        if(ind+1==n) return false;
        if(dp[ind]!=-1) return false;
        if(nums[ind]==nums[ind+1])
        {
            if(ind+2!=n && nums[ind+1]==nums[ind+2])
            {
                if(helper(nums,ind+3,n)) return true;
            }
            if(helper(nums,ind+2,n)) return true;
        }
        else if(ind+2!=n && (nums[ind]+1)==(nums[ind+1]) && (nums[ind+1]+1)==(nums[ind+2]))
        {
            if(helper(nums,ind+3,n)) return true;
        }
        dp[ind]=0;
        return false;
    }
    public boolean validPartition(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return helper(nums,0,n);
    }
}