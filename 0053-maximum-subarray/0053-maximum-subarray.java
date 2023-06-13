class Solution {
    public int maxSubArray(int[] nums) {
        int maxi=-(int)1e5;
        int cur=0;
        int n=nums.length;
        for(int x:nums)
        {
            cur+=x;
            if(maxi<cur)
                maxi=cur;
            if(cur<0)cur=0;
            // if(x>=0)
            // {
            //     if(cur<0)cur=0;
            //     cur+=x;
            // }
            // else{
            //     maxi=Math.max(maxi,cur);
            //     cur=Math.max(cur+x,x);
            //     // if(cur+x<0)cur=x;
            //     // else cur+=x;
            // }
        }
        return maxi;
    }
}