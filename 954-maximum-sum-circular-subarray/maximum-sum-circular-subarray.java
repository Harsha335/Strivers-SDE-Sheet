class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max=0;
        int maxi=nums[0];
        int min=0;
        int mini=nums[0];
        int total=0;
        for(int x:nums)
        {
            max=Math.max(max+x,x);
            min=Math.min(min+x,x);
            maxi=Math.max(maxi,max);
            mini=Math.min(mini,min);
            total+=x;
        }
        if(maxi<0) return maxi;
        return Math.max(maxi,total-mini);
    }
}