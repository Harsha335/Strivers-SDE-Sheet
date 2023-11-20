class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        HashMap<Character,Integer> lastInd=new HashMap<>();
        lastInd.put('M',0);
        lastInd.put('G',0);
        lastInd.put('P',0);
        int n=travel.length;
        int[]preSum=new int[n+1];
        for(int i=0;i<n;i++)
        {
            preSum[i+1]=preSum[i]+travel[i];
        }
        int output=0;
        for(int i=0;i<=n;i++)
        {
            String s=garbage[i];
            for(char c:s.toCharArray())
            {
                output+=1;
                lastInd.put(c,i);
            }
        }
        for(char c:lastInd.keySet())
        {
            output+=preSum[lastInd.get(c)];
        }
        return output;
    }
}