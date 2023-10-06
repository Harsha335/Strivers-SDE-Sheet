class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int output=0;
        int sum=0;
        for(int x:nums)
        {
            sum+=x;
            output+=map.getOrDefault(sum-goal,0);
            map.put(sum,map.getOrDefault(sum,0)+1);
            // System.out.println(map);
            // System.out.println(output);
        }
        return output;
    }
}