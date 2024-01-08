class Solution {
    public int minMoves2(int[] nums) {
        long left = 0l;
        long right = 0l;
        int n = nums.length;
        Arrays.sort(nums);
        for(int i = 1; i<n ;i++)
        {
            right += nums[i] - nums[0];
        }
        long ans = right;
        // System.out.println(ans);

        for(int i = 1 ;i < n; i++)
        {
            long diff = nums[i] - nums[i-1];
            right -= (n-i)*(diff);
            left += i*(diff);
            // System.out.println(left+" "+right);
            ans = Math.min(ans, left+right);
        }
        return (int)ans;
    }
}