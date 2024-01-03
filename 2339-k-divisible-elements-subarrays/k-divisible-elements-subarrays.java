class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        HashSet<ArrayList<Integer>> set = new HashSet<>();
        int n = nums.length;
        for(int i = 0; i < n; i++)
        {
            ArrayList<Integer> list = new ArrayList<>();
            int count = 0;
            for(int j = i; j < n; j++)
            {
                if(nums[j]%p == 0)
                    count++;
                if(count > k)
                    break;
                // System.out.println(set);
                list.add(nums[j]);
                set.add((ArrayList)list.clone());
            }
        }
        return set.size();
    }
}