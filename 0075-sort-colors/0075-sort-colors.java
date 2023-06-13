class Solution {
    void swap(int[] nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void sortColors(int[] nums) {
        int zero=0;
        int two=nums.length-1;
        int cur=0;
        while(cur<=two)
        {
            if(nums[cur]==2)
            {
                swap(nums,cur,two);
                two-=1;
            }
            else if(nums[cur]==1)
            {
                cur++;
            }
            else{
                swap(nums,cur,zero);
                cur++;
                zero++;
            }
        }
    }
}