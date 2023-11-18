class Solution {
    private int binarySearch(long[] preSum,int i,int j,int tar,int n,int k)
    {
        int ans=n;
        while(i<=j)
        {
            int mid=i+((j-i)>>1);
            if((long)tar*(n-mid)-(preSum[n]-preSum[mid])<=k)
            {
                ans=mid;
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return n-ans+1;
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        long preSum[]=new long[n];
        preSum[0]=0;
        for(int i=1;i<n;i++)
        {
            preSum[i]=nums[i-1]+preSum[i-1];
            // if(i!=0)
            // {
            //     preSum[i]+=preSum[i-1];
            // }
        }
        int output=1;
        for(int i=1;i<n;i++)
        {
            output=Math.max(output,binarySearch(preSum,0,i,nums[i],i,k));
        }
        return output;
    }
}