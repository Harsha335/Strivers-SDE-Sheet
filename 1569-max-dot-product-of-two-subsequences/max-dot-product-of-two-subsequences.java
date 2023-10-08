class Solution {
    int n1,n2;
    int dp[][];
    private int helper(int nums1[],int nums2[],int i,int j)
    {
        if(i==n1 || j==n2)
            return -(int)1e9;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=-(int)1e9;
                    // System.out.println(k+"-"+kk);
        ans=Math.max(ans,nums1[i]*nums2[j]+Math.max(0,helper(nums1,nums2,i+1,j+1)));
        ans=Math.max(ans,helper(nums1,nums2,i+1,j));
        ans=Math.max(ans,helper(nums1,nums2,i,j+1));
        return dp[i][j]=ans;
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        n1=nums1.length;
        n2=nums2.length;
        dp=new int[n1][n2];
        for(int x[]:dp)
        {
            Arrays.fill(x,-1);
        }
        return helper(nums1,nums2,0,0);
    }
}