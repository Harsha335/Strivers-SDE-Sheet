class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxcount=0;
        int count=0;
        for(int x:nums)
        {
            if(x==1)
            {
                count++;
            }
            else{
                maxcount=Math.max(count,maxcount);
                count=0;
            }
        }
        return Math.max(count,maxcount);
    }
}