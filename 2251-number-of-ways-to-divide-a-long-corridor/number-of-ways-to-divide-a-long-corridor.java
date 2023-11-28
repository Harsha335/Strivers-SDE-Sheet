class Solution {
    public int numberOfWays(String corridor) {
        // List<Integer> list=new ArrayList<>();
    
        long output=1;
        int mod=(int)1e9+7;
        int count=0;
        int pre=0;
        int i=0;
        int p=0;
        for(char c:corridor.toCharArray())
        {
            if(c=='S')
            {
                if(count==2)
                {
                    output=(output*(i-pre))%mod;
                    count=0;
                }
                count++;
                pre=i;
            }
            else
                p++;
            i++;
        }
        if(p+1>=corridor.length() || count==1)
            return 0;
        return (int)output;
    }
}