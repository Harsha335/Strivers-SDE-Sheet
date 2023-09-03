class Solution {
    int n;
    // HashMap<List<Integer>,Integer> map;
    int[][][] dp;
    int helper(int[] prices,int ind,int bought,int rem)
    {
        if(ind==n || rem==0)
        {
            return 0;
        }
        // List<Integer> curr=Arrays.asList(ind,bought?1:0,rem);
        if(dp[ind][bought][rem]!=-1) return dp[ind][bought][rem];
        // if(map.containsKey(curr)) return map.get(curr);
        int ans1=0,ans2=0,ans3=0;
        if(bought==1)
        {
            // if(prices[ind]>price)
            // {
                ans1=prices[ind]+helper(prices,ind+1,0,rem-1);
            // }
        }
        else{
            ans2=-prices[ind]+helper(prices,ind+1,1,rem);
        }
        ans3=helper(prices,ind+1,bought,rem);
        // System.out.println(curr);
        // map.put(curr,Math.max(Math.max(ans1,ans2),ans3));
        
        // return map.get(curr);
        return dp[ind][bought][rem]=Math.max(Math.max(ans1,ans2),ans3);
    }
    public int maxProfit(int k, int[] prices) {
        n=prices.length;
        // map=new HashMap<>();
        dp=new int[n][2][k+1];
        for(int[][] x:dp)
        {
            for(int xx[]:x)
                Arrays.fill(xx,-1);
        }
        return helper(prices,0,0,k);
    }
}