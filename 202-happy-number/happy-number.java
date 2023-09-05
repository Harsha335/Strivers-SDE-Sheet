class Solution {
    int sq(int n)
    {
        int output=0;
        while(n>0)
        {
            output+=Math.pow(n%10,2);
            n/=10;
        }
        return output;
    }
    public boolean isHappy(int n) {
        if(n>=1 && n<=9)
        {
            if(n==1 || n==7)
                return true;
            return false;
        }
        return isHappy(sq(n));
    }
}