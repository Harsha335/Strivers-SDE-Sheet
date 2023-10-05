class Solution {
    int prefixSum[];
    int dp[][];
    // int find(int i,int j,int[] stoneValue)
    // {
    //     int presum=0;
    //     if(i!=0)
    //         presum=prefixSum[i-1];
    //     int ans=0;
    //     int abs=(int)1e9;
    //     for(int k=i;k<=j;k++)
    //     {
    //         int cur1=prefixSum[k]-presum;
    //         int cur2=prefixSum[j]-prefixSum[k];
    //         if(Math.abs(cur2-cur1)<abs)
    //         {
    //             abs=Math.abs(cur2-cur1);
    //             ans=k;
    //         }
    //     }
    //     return ans;
    // }
    int helper(int[] stoneValue,int i,int j)
    {
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int presum=0;
        if(i!=0)
            presum=prefixSum[i-1];
        int ans=0;
        for(int k=i;k<j;k++)
        {
            int left=prefixSum[k]-presum;
            int right=prefixSum[j]-prefixSum[k];
            if(left>right)
            {
                ans=Math.max(ans,right+helper(stoneValue,k+1,j));
            }
            else if(right>left)
            {
                ans=Math.max(ans,left+helper(stoneValue,i,k));
            }
            else{
                ans=Math.max(ans,Math.max(left+helper(stoneValue,i,k),right+helper(stoneValue,k+1,j)));
            }
        }
        return dp[i][j]=ans;

        // int ind=find(i,j,stoneValue);
        // System.out.println(i+" "+j+" "+ind);
        // int presum=0;
        // if(i!=0)
        //     presum=prefixSum[i-1];
        // int ans=0;
        // if(prefixSum[ind]-presum<prefixSum[j]-prefixSum[ind])
        // {
        //     ans=prefixSum[ind]-presum+helper(stoneValue,i,ind);
        // }
        // else if(prefixSum[ind]-presum>prefixSum[j]-prefixSum[ind])
        //     ans=prefixSum[j]-prefixSum[ind]+helper(stoneValue,ind+1,j);
        // else{
        //     // if(ind-i+1>=j-ind)
        //         ans=prefixSum[ind]-presum+helper(stoneValue,i,ind);
        //     // else
        //         ans=Math.max(ans,prefixSum[j]-prefixSum[ind]+helper(stoneValue,ind+1,j));
        // }
        // return ans;
    }
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        prefixSum=new int[n];
        prefixSum[0]=stoneValue[0];
        for(int i=1;i<n;i++)
        {
            prefixSum[i]=prefixSum[i-1]+stoneValue[i];
            // System.out.println(prefixSum[i]);
        }
        dp=new int[n][n];
        for(int x[]:dp)
            Arrays.fill(x,-1);
        return helper(stoneValue,0,n-1);
    }
}