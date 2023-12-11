class Solution {
    public int findSpecialInteger(int[] arr) {
        int n=arr.length;
        int tarLen=(int)Math.ceil(n/4);
        // int output=-1;
        int currLen=1;
        for(int i=0;i<n-1;i++)
        {
            if(arr[i]==arr[i+1])
            {
                currLen++;
            }
            else{
                if(currLen>tarLen)
                    return arr[i];
                currLen=1;
            }
        }
        return arr[n-1];
    }
}