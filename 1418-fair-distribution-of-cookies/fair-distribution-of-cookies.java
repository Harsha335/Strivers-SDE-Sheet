class Solution {
    int maxi,n;
    void helper(int[] cookies,int k,int ind,int[] data,int zeroCount)
    {
        if(n-ind<zeroCount)
            return;
        if(ind==n)
        {
            maxi=Math.min(maxi,Arrays.stream(data).max().getAsInt());
            return;
        }
        for(int i=0;i<k;i++)
        {
            zeroCount-=data[i]==0?1:0;
            data[i]+=cookies[ind];
            helper(cookies,k,ind+1,data,zeroCount);
            data[i]-=cookies[ind];
            zeroCount+=data[i]==0?1:0;
        }
    }
    public int distributeCookies(int[] cookies, int k) {
        maxi=(int)1e9;
        n=cookies.length;
        int data[]=new int[k];
        helper(cookies,k,0,data,k);
        return maxi;
    }
}