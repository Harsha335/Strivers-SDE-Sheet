class Solution {
    public int maxProduct(int[] nums) {
        int max1=-1;
        int max2=-1;
        for(int x:nums)
        {
            if(max1<x)
            {
                max2=max1;
                max1=x;
            }
            else if(max2<x)
            {
                max2=x;
            }
        }
        return (max1-1)*(max2-1);
    }
}