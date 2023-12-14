class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        int ind=0;
        int n=coins.length;
        long preSum=0;
        int right=0;
        Arrays.sort(coins);
        int count=0;
        for(int tar=1;tar<=target;tar++)
        {
            if(preSum>=tar)
            {
                while(ind<n && coins[ind]<=tar)
                {
                    preSum+=coins[ind];
                    ind++;
                }
                continue;
            }
            if(ind>=n || coins[ind]>tar)
            {
                count+=1;
            // System.out.println(tar+"--");
                preSum+=tar;
            }
            while(ind<n && coins[ind]==tar)
            {
                ind+=1;
                preSum+=tar;
            }
            // System.out.println(preSum);
        }
        return count;
    }
}