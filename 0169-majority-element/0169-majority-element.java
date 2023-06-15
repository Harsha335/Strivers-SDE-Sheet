class Solution {
    public int majorityElement(int[] nums) {
        int ind=0,count=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==nums[ind])
            {
                count++;
            }
            else
            {
                count--;
                if(count==0)
                {
                    ind=i;
                    count++;
                }
            }
        }
        return nums[ind];
    }
}