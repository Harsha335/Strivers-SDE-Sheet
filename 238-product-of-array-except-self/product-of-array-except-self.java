class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        // int pre[]=new int[n];
        // int suffix[]=new int[n];
        int output[]=new int[n];
        output[0]=1;
        for(int i=1;i<n;i++)
        {
            output[i]=output[i-1]*nums[i-1];
        }
        int suffix=nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            output[i]=output[i]*suffix;
            suffix*=nums[i];
        }
        return output;
    }
}