class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        // int end=0;
        int sum=0;
        int minLen=(int)1e9;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
            if(sum>=target)
            {
                while(start<n && (sum-nums[start])>=target)
                {
                    // System.out.println(start+" "+sum);
                    sum-=nums[start];
                    start++;
                }
                minLen=Math.min(minLen,i-start+1);
            }
        }
        return (minLen==(int)1e9)?0:minLen;
    }
}