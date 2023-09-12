class Solution {
    int n;
    int dp[][];
    int helper(int[] prices,int fee,int ind,boolean isBought)
    {
        if(ind==n)return 0;
        if(dp[ind][isBought?1:0]!=-1)return dp[ind][isBought?1:0];
        int maxi=0;
        if(!isBought)
        {
            maxi=Math.max(0,-prices[ind]-fee+helper(prices,fee,ind+1,true));
        }
        else{
            maxi=prices[ind]+helper(prices,fee,ind+1,false);
        }
        maxi=Math.max(maxi,helper(prices,fee,ind+1,isBought));
        return dp[ind][isBought?1:0]=maxi;
    }
    public int maxProfit(int[] prices, int fee) {
        n=prices.length;
        dp=new int[n][2];
        for(int x[]:dp)
        {
            Arrays.fill(x,-1);
        }
        return helper(prices,fee,0,false);
    }
}