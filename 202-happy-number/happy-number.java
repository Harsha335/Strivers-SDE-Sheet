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
    HashSet<Integer> set=new HashSet<>();
    public boolean isHappy(int n) {
        if(n==1)
            return true;
        if(set.contains(n))
            return false;
        set.add(n);
        return isHappy(sq(n));
    }
}