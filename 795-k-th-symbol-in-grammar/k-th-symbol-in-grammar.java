class Solution {
    public int kthGrammar(int n, int k) {
        int curr=0;
        int left=0,right=(int)Math.pow(2,n-1);
        for(int i=1;i<n;i++)
        {
            int mid=left+(right-left)/2;
            if(k<=mid)
            {
                right=mid;
            }
            else{
                left=mid+1;
                curr=1-curr;
            }
        }
        return curr;
    }
}