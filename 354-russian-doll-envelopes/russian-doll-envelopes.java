class Solution {
    private int binarySearch(int arr[],int i,int j,int x)
    {
        // int ind=0;
        while(i<j)
        {
            int mid=i+(j-i)/2;
            if(arr[mid]>=x)
            {
                // ind=mid;
                j=mid;
            }
            else
                i=mid+1;
        }
        return j;
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0]!=b[0])
                return a[0]-b[0];
            return b[1]-a[1];
        });
        int len=0;
        int n=envelopes.length;
        int sorted[]=new int[n];
        for(int x[]:envelopes)
        {
            int index=binarySearch(sorted,0,len,x[1]);
            sorted[index]=x[1];
            if(index==len)
                len+=1;
        }
        return len;
    }
}