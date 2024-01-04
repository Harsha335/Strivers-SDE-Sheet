class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x: nums)
        {
            map.put(x, map.getOrDefault(x,0) + 1);
        }
        int count = 0;
        for(int x: map.keySet())
        {
            int xcount = map.get(x);
            if(xcount == 1)
                return -1;
            count += Math.ceil((double)xcount/3);
        }
        return count;
    }
}