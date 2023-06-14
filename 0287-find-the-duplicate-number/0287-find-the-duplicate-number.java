class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            int ind=Math.abs(nums[i])-1;
            if(nums[ind]>0)nums[ind]=-nums[ind];
            else{
                return ind+1;
            }
        }
        return -1;
        // int slow=nums[0];
        // int fast=nums[0];
        // do
        // {
        //     slow=nums[slow];
        //     fast=nums[nums[fast]];
        // }while(slow!=fast);
        // fast=nums[0];
        // while(slow!=fast)
        // {
        //     slow=nums[slow];
        //     fast=nums[fast];
        // }
        // return slow;
    }
}