class Solution {
    private int counter(int ele)
    {
        if(ele==1 || ele==0)
            return 0;
        return (ele/10)+10*(counter(ele/10));
    }
    //CHANGE FOR TAR - 0
    private int helper(int num,int multi,int over,int tar)//TAR=0 --> INT LOW
    {
        if(num==0)
            return 0;
        int ans=counter(multi)*(num%10);
        if((num%10)>tar)//TAR=0 --> && (tar!=0 || multi<=low))
        {
            ans+=multi;
        }
        else if(tar==(num%10))
        {
            ans+=(over+1);
        }
        return ans+helper(num/10,multi*10,(num%10)*multi+over,tar);
    }
    public int countDigitOne(int n) {
        return helper(n,1,0,1);
    }
}