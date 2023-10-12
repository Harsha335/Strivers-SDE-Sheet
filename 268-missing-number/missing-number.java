class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        // SUM SOLUTION
        // int total=(n*(n+1))/2;
        // for(int x:nums)
        //     total-=x;
        // return total;

        // XOR SOLUTION
        int xor=0;
        for(int i=1;i<=n;i++)
            xor^=i;
        for(int x:nums)
            xor^=x;
        return xor;
    }
}