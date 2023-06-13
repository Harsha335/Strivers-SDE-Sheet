class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output=new ArrayList<>();
        output.add(Arrays.asList(1));
        int n=0;
        for(int i=1;i<numRows;i++)
        {
            List<Integer> cur=new ArrayList<>();
            cur.add(1);
            for(int j=1;j<i;j++)
            {
                cur.add(output.get(n).get(j-1)+output.get(n).get(j));
            }
            cur.add(1);
            output.add(cur);
            n++;
        }
        return output;
    }
}