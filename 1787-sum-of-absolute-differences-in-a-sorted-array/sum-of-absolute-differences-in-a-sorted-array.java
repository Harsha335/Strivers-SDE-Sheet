class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int left=0;
        int right=0;
        for(int x:nums)
        {
            right+=(x-nums[0]);
        }
        int n=nums.length;
        int output[]=new int[n];
        output[0]=right;
        for(int i=1;i<n;i++)
        {
            left+=i*(nums[i]-nums[i-1]);
            right-=(n-i)*(nums[i]-nums[i-1]);
            output[i]=left+right;
        }
        return output;
    }
}