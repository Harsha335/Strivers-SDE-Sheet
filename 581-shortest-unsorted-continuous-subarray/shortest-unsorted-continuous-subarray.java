class Solution { 
    public int findUnsortedSubarray(int[] nums) {
        int n=nums.length;
        int start=0,end=n-1;
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]<=nums[i+1])
            {
                start+=1;
            }
            else
                break;
        }
        if(start==n-1) return 0;
        for(int i=n-1;i>0;i--)
        {
            if(nums[i-1]<=nums[i])
            {
                end-=1;
            }
            else
                break;
        }
        // System.out.println(start+" "+end);
        int min=(int)1e9,max=-(int)1e9;
        for(int i=start;i<=end;i++)
        {
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        // System.out.println(min+" "+max);
        while(start>0 || end<n-1)
        {
            if(start>0 && nums[start-1]>min)
                start--;
            else if(end<n-1 && nums[end+1]<max)
                end++;
            else    
                break;
        }
        return end-start+1;
    }
}