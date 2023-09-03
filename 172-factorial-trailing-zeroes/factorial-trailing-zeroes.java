class Solution {
    public int trailingZeroes(int n) {
        //a num has 'x' 0's, if it is a multiple of 10 'x' times
        //10-(2*5) or (5*2)
        //in a factorial there are more 2's than 5's --> number of 5's are number of trailingzeros
        int count=0;
        while(n>0)
        {
            n/=5;
            count+=n;
        }
        return count;
    }
}