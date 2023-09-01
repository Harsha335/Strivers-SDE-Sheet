class Solution {
    int findBits(int num)
    {
        int count=0;
        while(num>0)
        {
            if(num%2!=0)
                count++;
            num>>=1;
        }
        return count;
    }
    public int[] countBits(int n) {
        int output[]=new int[n+1];
        for(int i=0;i<=n;i++)
        {
            output[i]=findBits(i);
        }
        return output;
    }
}