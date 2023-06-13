class Solution {
    public int maxProfit(int[] prices) {
        int output=0;
        int n=prices.length;
        int mini=prices[0];
        for(int i=1;i<n;i++)
        {
            if(mini>prices[i])
                mini=prices[i];
            else
            {
                int dif=prices[i]-mini;
                if(dif>output)
                    output=dif;
            }
                
            // mini=Math.min(mini,prices[i]);
            // output=Math.max(output,prices[i]-mini);
        }
        return output;
    }
}