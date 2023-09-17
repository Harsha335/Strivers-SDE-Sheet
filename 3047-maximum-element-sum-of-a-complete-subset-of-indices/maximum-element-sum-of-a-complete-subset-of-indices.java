class Solution {
    public long maximumSum(List<Integer> nums) {
        long output=0;
        HashMap<Long,Long> map=new HashMap<>();
        long ind=1;
        for(long x:nums)
        {
            long remain=ind++;
            for(long i=2;i*i<=remain;i++)
            {
                while(remain%(i*i)==0)
                    remain/=(i*i);
            }
            // System.out.println(map);
            // System.out.println(x+" "+remain);
            map.put(remain,map.getOrDefault(remain,0l)+x);
            output=Math.max(output,map.get(remain));
        }
        return output;
    }
}