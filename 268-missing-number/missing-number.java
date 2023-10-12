class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int total=(n*(n+1))/2;
        for(int x:nums)
            total-=x;
        return total;
    }
}