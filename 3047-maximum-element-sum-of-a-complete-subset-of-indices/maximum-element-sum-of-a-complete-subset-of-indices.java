class Solution {
    public long maximumSum(List<Integer> nums) {
        long output=0;
        HashMap<Long,Long> map=new HashMap<>();
        long ind=1;
        for(int x:nums)
        {
            long remain=ind++;
            for(int i=2;i*i<=remain;i++)
            {
                while(remain%((long)i*i)==0)
                    remain/=((long)i*i);
            }
            // System.out.println(map);
            // System.out.println(x+" "+remain);
            map.put((long)remain,map.getOrDefault((long)remain,0l)+(long)x);
            output=Math.max(output,map.get((long)remain));
        }
        return output;
    }
}