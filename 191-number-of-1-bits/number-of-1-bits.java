public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count=0;
        // System.out.println(n);
        while(n!=0)
        {
            // count+=((n&1)==1?1:0);
            // n>>=1;
            n=(n&(n-1));
            count++;
        }
        return count;
    }
}