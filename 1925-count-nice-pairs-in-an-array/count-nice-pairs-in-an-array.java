class Solution {
    private int rev(int num)
    {
        int out=0;
        while(num>0)
        {
            out=out*10+num%10;
            num/=10;
        }
        return out;
    }
    public int countNicePairs(int[] nums) {
        //-18 9 -18 -18 9
        HashMap<Integer,Integer> map=new HashMap<>();
        int output=0;
        int mod=(int)1e9+7;
        for(int x:nums)
        {
            int sum=x-rev(x);
            // System.out.println(sum);
            output=(output+map.getOrDefault(sum,0))%mod;
            map.put(sum,map.getOrDefault(sum,0)+1);
            // System.out.println(map);
        }
        return output;
    }
}