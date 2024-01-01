class Solution {
    private int gcd(int a, int b)
    {
        if(a == 0)
            return b;
        return gcd(b%a, a);
    }
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        int req = uniqueCnt1 + uniqueCnt2;
        long lcm = (long)((long)divisor1*divisor2)/gcd(Math.min(divisor1, divisor2), Math.max(divisor1, divisor2));
        long low = 0, high = (long)1e10;
        while(low <= high)
        {
            long mid = (low+high)>>1;
            boolean x = (mid - mid/divisor1) >= uniqueCnt1;
            boolean y = (mid - mid/divisor2) >= uniqueCnt2;
            boolean z = (mid - mid/lcm) >= (uniqueCnt1 + uniqueCnt2);
            if(x && y && z == true)
                high = mid-1;
            else
                low = mid+1;
        }
        return (int)low;
    }
}