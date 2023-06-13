class Solution {
    public int maxProfit(int[] prices) {
        int output=0;
        int n=prices.length;
        int mini=prices[0];
        for(int i=0;i<n;i++)
        {
            mini=Math.min(mini,prices[i]);
            output=Math.max(output,prices[i]-mini);
        }
        return output;
    }
}