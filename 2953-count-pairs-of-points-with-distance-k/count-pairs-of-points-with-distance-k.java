class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        HashMap<List<Integer>,Integer> counter=new HashMap<>();
        int n=coordinates.size();
        int count=0;
        for(List<Integer> x:coordinates)
        {
            for(int kk=0;kk<=k;kk++)
            {
                // if(((x.get(0)^kk) +(x.get(1)^(k-kk)))==k)
                count+=counter.getOrDefault(Arrays.asList((x.get(0)^kk),(x.get(1)^(k-kk))),0);
            }
            counter.put(Arrays.asList(x.get(0),x.get(1)),counter.getOrDefault(Arrays.asList(x.get(0),x.get(1)),0)+1);
            // System.out.println(counter);
        }
        return count;
    }
}