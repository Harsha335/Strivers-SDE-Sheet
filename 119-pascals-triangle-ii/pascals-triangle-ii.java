class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> output=new ArrayList<>();
        output.add(1);
        int curr=1;
        int up=rowIndex,down=1;
        for(int i=1;i<=rowIndex;i++)
        {
            curr=(int)((double)curr*up/down);
            output.add(curr);
            up--;
            down++;
        }
        return output;
    }
}