class Solution {
    class Trie{
        Trie arr[];
        boolean isEnd;
        Trie(int maxLen)
        {
            arr = new Trie[maxLen+1];
            isEnd = false;
        }
    }
    public int countDistinct(int[] nums, int k, int p) {
        // HashSet<ArrayList<Integer>> set = new HashSet<>();
        int maxi = 0;
        for(int ele: nums)
        {
            maxi = Math.max(maxi,ele);
        }
        Trie root = new Trie(maxi);
        int n = nums.length;
        int output = 0;
        for(int i = 0; i < n; i++)
        {
            // ArrayList<Integer> list = new ArrayList<>();
            Trie curr = root;
            int count = 0;
            for(int j = i; j < n; j++)
            {
                if(nums[j]%p == 0)
                    count++;
                if(count > k)
                    break;
                if(curr.arr[nums[j]] == null)
                {
                    curr.arr[nums[j]] = new Trie(maxi);
                }
                if(curr.arr[nums[j]].isEnd == false)
                {
                    output ++;
                    curr.arr[nums[j]].isEnd = true;
                }
                curr = curr.arr[nums[j]];
                // System.out.println(set);
                // list.add(nums[j]);
                // set.add((ArrayList)list.clone());
            }
        }
        return output;
    }
}