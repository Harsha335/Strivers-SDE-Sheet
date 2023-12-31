class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        if(right==0) return 0;
        if(nums[right]>nums[right-1]) return right;
        right-=1;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1])
            {
                left=mid+1;
            }
            else    right=mid;
        }
        return right;
    }
}