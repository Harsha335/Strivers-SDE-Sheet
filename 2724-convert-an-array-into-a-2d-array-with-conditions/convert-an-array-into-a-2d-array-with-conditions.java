class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        int ind = 0;
        int length = 1;
        // int count 
        int pre = -1;
        for(int ele: nums)
        {
            if(ele == pre)
            {
                // ind = 0;
                // while(ind < length)
                // {
                //     if(list.get(ind).get(list.get(ind).size()-1) != ele)
                //     {
                //         break;
                //     }
                //     ind ++;
                // }
                ind++;
                if(ind == length)
                {
                    list.add(new ArrayList<>());
                    length++;
                }
            }
            else
                ind = 0;
            list.get(ind).add(ele);
            pre = ele;
        }
        return list;
    }
}