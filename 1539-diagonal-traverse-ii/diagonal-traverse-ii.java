class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n=nums.size();
        int lengths[]=new int[n];
        int countLen=0;
        for(int i=0;i<n;i++)
        {
            lengths[i]=nums.get(i).size();
            countLen+=lengths[i];
        }
        int output[]=new int[countLen];
        int ind=0;
        TreeMap<Integer,List<Integer>> map=new TreeMap<>();
        for(int i=n-1;i>=0;i--)
        {
            for(int j=lengths[i]-1;j>=0;j--)
            {
                map.putIfAbsent(i+j,new ArrayList<>());
                map.get(i+j).add(nums.get(i).get(j));
            }
        }
        for(List<Integer> x:map.values())
        {
            for(int ele:x)
            {
                output[ind++]=ele;
            }
        }
        return output;
    }
}