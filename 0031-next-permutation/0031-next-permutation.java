class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n==1)return;
        int ind=-1;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        if(ind==-1)
        {
            int left=0;
            int right=n-1;
            while(left<right)
            {
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            
            }
            return;
        }
        int nexty=ind+1;
        int dif=nums[nexty]-nums[ind];
        for(int i=ind+2;i<n;i++)
        {
            if(nums[i]-nums[ind]>0 && nums[i]-nums[ind]<dif)
            {
                dif=nums[i]-nums[ind];
                nexty=i;
            }
        }
        int temp=nums[ind];
        nums[ind]=nums[nexty];
        nums[nexty]=temp;
        for(int i=ind+1;i<n-1;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                if(nums[i]>nums[j])
                {
                    temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
    }
}