class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        final int len = nums[0].length();
        List<Integer> map[] = new ArrayList[len];
        int n = nums.length;
        for(int i = 0; i<len; i++)
        {
            map[i] = new ArrayList<>();
            for(int ind = 0; ind < n ; ind++)
            {
                map[i].add(ind);
            }
            final int ii = i;
            Collections.sort(map[i],(a,b)->
                 nums[a].substring(len-ii-1).compareTo(nums[b].substring(len-ii-1))
            );
        }
        int output[] = new int[queries.length];
        int ind = 0;
        for(int q[]: queries)
        {
            output[ind++] = map[q[1]-1].get(q[0]-1);
        }
        return output;
    }
}