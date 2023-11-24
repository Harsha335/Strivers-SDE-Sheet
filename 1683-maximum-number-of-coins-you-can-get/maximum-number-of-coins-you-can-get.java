class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n=piles.length;
        int i=0,j=n-2;
        int output=0;
        while(i<j)
        {
            output+=piles[j];
            j-=2;
            i++;
        }
        return output;
    }
}