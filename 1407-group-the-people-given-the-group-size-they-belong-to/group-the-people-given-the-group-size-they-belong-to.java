class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int ind=0;
        List<List<Integer>> output=new ArrayList<>();
        for(int x:groupSizes)
        {
            map.putIfAbsent(x,new ArrayList<>());
            map.get(x).add(ind++);
            if(map.get(x).size()==x)
            {
                output.add(new ArrayList(map.get(x)));
                // System.out.println(output);
                map.get(x).clear();
            }
        }
        return output;
    }
}