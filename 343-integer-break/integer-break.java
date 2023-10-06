class Solution {
    public int integerBreak(int n) {
        if(n==2 || n==3)
            return n-1;
        int output=1;
        while(n>4)
        {
            output*=3;
            n-=3;
        }
        return output*n;
    }
}