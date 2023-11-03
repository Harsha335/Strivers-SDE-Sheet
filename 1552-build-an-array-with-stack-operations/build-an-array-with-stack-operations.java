class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> output=new ArrayList<>();
        int curr=0;
        int m=target.length;
        for(int i=1;i<=n;i++)
        {
            if(target[curr]==i)
            {
                output.add("Push");
                curr++;
            }
            else{
                output.add("Push");
                output.add("Pop");
            }
            if(m==curr)
                return output;
        }
        return output;
    }
}