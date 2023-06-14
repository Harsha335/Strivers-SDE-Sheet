class Solution {
    double helper(double x,int n)
    {
        if(n==1 || n==-1)return x;
        double output=helper(x,n/2);
        return output*output*(n%2==0?1:x);
        
    }
    public double myPow(double x, int n) {
        if(n==0)return 1;
        double output=helper(x,n);
        return n<0?1/output:output;
    }
}