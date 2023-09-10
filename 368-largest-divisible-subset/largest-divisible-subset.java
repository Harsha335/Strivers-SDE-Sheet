class Solution {
    List<Integer> dp[][];
    List<Integer> helper(int[] nums,int pre,int ind,int n)
    {
        if(ind==n)return new ArrayList<>();
        if(dp[pre][ind]!=null)return dp[pre][ind];
        // int ans=0;
        List<Integer> cur1=new ArrayList<>();
            // System.out.println(ind+" "+pre);
        if(pre==0 || nums[ind]%nums[pre-1]==0)
        {
            cur1.add(nums[ind]);
            cur1.addAll(helper(nums,ind+1,ind+1,n));
        }
        List<Integer> cur2=new ArrayList<>();
        // cur2.add(nums[ind]);
        cur2.addAll(helper(nums,pre,ind+1,n));
        return dp[pre][ind]=(cur1.size()>cur2.size())?cur1:cur2;
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        dp=new ArrayList[n+1][n];

        return helper(nums,0,0,n);//pre+1
    }
}