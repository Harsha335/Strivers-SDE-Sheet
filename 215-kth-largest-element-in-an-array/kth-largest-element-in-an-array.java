class Solution {
    int quicksort(int i,int j, int nums[],int position)
    {
        if(i<=j)
        {
            int pos=sorting(i,j,nums);
            if(pos==position)
            {
                return nums[pos];
            }
            int value;
            if((value=quicksort(i,pos-1,nums,position))!=(int)1e9)
            {
                return value;
            }
            if((value=quicksort(pos+1,j,nums,position))!=(int)1e9)
            {
                return value;
            }
        }
        return (int)1e9;
    }
    int sorting(int i,int j,int nums[])
    {
        int pivot=nums[i];
        int start=i;
        int end=i+1;
        int temp;
        while(end!=(j+1))
        {
            if(pivot>nums[end])
            {
                temp=nums[++start];
                nums[start]=nums[end];
                nums[end]=temp;
            }
            end++;
        }
        temp=nums[start];
        nums[start]=nums[i];
        nums[i]=temp;
        return start;
    }
    public int findKthLargest(int[] nums, int k) {
        //or use QUICK SORT
        int n=nums.length;
        int position=n-k;
        return quicksort(0,n-1,nums,position);
        // PriorityQueue<Integer> sortedK=new PriorityQueue<>();
        // for(int x:nums)
        // {
        //     sortedK.add(x);
        //     if(sortedK.size()==(k+1))
        //         sortedK.poll();
        // }
        // return sortedK.peek();
    }
}