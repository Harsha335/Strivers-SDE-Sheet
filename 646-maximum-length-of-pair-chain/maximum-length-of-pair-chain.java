class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count=0;
        int pre=-(int)1e5;
        for(int x[]:pairs)
        {
            if(x[0]>pre)
            {
                count++;
                pre=x[1];
            }
        }
        return count;
    }
}