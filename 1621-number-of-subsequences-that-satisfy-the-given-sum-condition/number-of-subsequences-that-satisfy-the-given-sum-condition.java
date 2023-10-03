class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int mod=(int)1e9+7;
        int power[]=new int[n];
        power[0]=1;
        for(int k=1;k<n;k++)
        {
            power[k]=(power[k-1]*2)%mod;
        }
        
        int i=0;
        int j=n-1;
        int output=0;
        while(i<=j)
        {
            while(i<=j && nums[i]+nums[j]>target)
            {
                j--;
            }
            if(i>j)
                break;
            output=(output+power[j-i])%mod;
            i++;
        }
        return output;
    }
}