class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        HashMap<Long,Integer> map[] = new HashMap[n];
        for(int x = 0; x<n; x++)
            map[x] = new HashMap<>();
        long output = 0;
        for(int i = 1; i<n ; i++)
        {
            // System.out.println(nums[i]);
            // int sum
            for(int j = 0; j<i ; j++)
            {
                long diff = (long) nums[i] - nums[j]; 

                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue; 
                }


                map[i].put(diff, map[i].getOrDefault(diff, 0) + 1);  
                if (map[j].containsKey(diff)) {
                    map[i].put(diff, map[i].get(diff) + map[j].get(diff));
                    output += map[j].get(diff);
                }
            }
                    // System.out.println("----"+ map[i]);
        }
        return (int)output;
    }
}