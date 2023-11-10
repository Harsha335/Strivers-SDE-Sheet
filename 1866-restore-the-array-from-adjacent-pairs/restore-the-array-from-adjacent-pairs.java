class Solution {
    private void helper(int output[],int i,HashMap<Integer,List<Integer>> map,int curr,int parent)
    {
        for(int x:map.get(curr))
        {
            if(x!=parent)
            {
                output[i]=x;
                helper(output,i+1,map,x,curr);
            }
        }
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int x[]:adjacentPairs)
        {
            map.putIfAbsent(x[0],new ArrayList<>());
            map.putIfAbsent(x[1],new ArrayList<>());
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        int output[]=new int[adjacentPairs.length+1];
        int ind=0;
        for(int curr:map.keySet())
        {
            if(map.get(curr).size()==1)
            {
                output[ind]=curr;
                helper(output,1,map,curr,(int)1e9);
                break;
            }
        }
        return output;
    }
}