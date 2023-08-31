class Solution {
    boolean isPossible(int[] arr,int tar)
    {
        int count=0;
        for(int x:arr)
        {
            if(tar<=x) count++;
        }
        return count>=tar;
    }
    public int hIndex(int[] citations) {

        int mini=0;
        int maxi=0;
        for(int x:citations)
        {
            mini=Math.min(mini,x);
            maxi=Math.max(maxi,x);
        }
        int ans=-1;
        while(mini<=maxi)
        {
            int mid=mini+(maxi-mini)/2;
            // System.out.println(mid);
            if(isPossible(citations,mid))
            {
                ans=mid;
                mini=mid+1;
            }
            else
                maxi=mid-1;
        }
        return ans;
    }
}