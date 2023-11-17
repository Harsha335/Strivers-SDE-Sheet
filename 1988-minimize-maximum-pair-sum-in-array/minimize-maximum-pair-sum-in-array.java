class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int max=0;
        int n=nums.length;
        int i=0,j=n-1;
        while(i<j)
        {
            max=Math.max(max,nums[i]+nums[j]);
            i++;j--;
        }
        return max;
    }
}