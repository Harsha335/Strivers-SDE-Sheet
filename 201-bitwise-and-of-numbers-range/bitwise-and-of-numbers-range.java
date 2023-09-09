class Solution {
    int lsb(int x)
    {
        return (int)(Math.log(x)/Math.log(2));
    }
    public int rangeBitwiseAnd(int left, int right) {
        if(left==right)return left;
        int ans=0;
        int x1=lsb(left);
        int x2=lsb(right);
        
        // System.out.println(x1+"-"+x2);
        if(x1!=x2) return 0;
        while(((1<<x1)&left)==((1<<x2)&right))
        {
            ans+=(1<<x1)*(((1<<x1)&left)>0?1:0);
            x1-=1;
            x2-=1;
            // System.out.println(x1+" "+x2);
        }
        return ans;
    }
}