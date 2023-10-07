class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k==0)
            return 0;
        int i=0;
        int j=0;
        int n=nums.length;
        long curr=1;
        int output=0;
        while(j<n)
        {
            curr*=nums[j];
                while(j>=i && curr>=k)
                {
                    curr/=nums[i];
                    i++;
                }
                output+=(j-i)+1;
            j++;
        }
        return output;
    }
}