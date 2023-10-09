class Solution {
    int lowerBound(int[] nums,int target)
    {
        int n=nums.length;
        int i=0,j=n-1;
        int ans=-1;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid]==target)
                ans=mid;
            if(nums[mid]>=target)
            {
                j=mid-1;
            }
            else
                i=mid+1;
        }
        // if(ans==-1)
        //     return -1;
        return ans;
    }
    int upperBound(int[] nums,int target)
    {
        int n=nums.length;
        int i=0,j=n-1;
        int ans=-1;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid]==target)
                ans=mid;
            if(nums[mid]<=target)
            {
                // ans=mid;
                i=mid+1;
            }
            else
                j=mid-1;
        }
        // if(ans==-1 || nums[ans]!=target)
        //     return -1;
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] output=new int[2];
        output[0]=lowerBound(nums,target);
        output[1]=upperBound(nums,target);
        return output;
    }
}