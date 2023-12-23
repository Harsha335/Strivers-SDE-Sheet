class Solution {
    public boolean isPathCrossing(String path) {
        HashSet<List<Integer>> set=new HashSet<>();
        HashMap<Character,int[]> dir=new HashMap<>();
        dir.put('N',new int[]{0,1});
        dir.put('E',new int[]{-1,0});
        dir.put('W',new int[]{1,0});
        dir.put('S',new int[]{0,-1});
        int x=0,y=0;
        List<Integer> list=Arrays.asList(0,0);
        set.add(list);
        for(char c:path.toCharArray())
        {
            x+=dir.get(c)[0];
            y+=dir.get(c)[1];
            list=Arrays.asList(x,y);
            if(set.contains(list))
                return true;
            set.add(list);
        }
        return false;
    }
}