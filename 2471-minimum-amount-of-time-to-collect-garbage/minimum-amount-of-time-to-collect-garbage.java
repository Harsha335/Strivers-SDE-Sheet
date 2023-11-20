class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        HashMap<Character,Integer> counter=new HashMap<>();
        counter.put('M',0);
        counter.put('G',0);
        counter.put('P',0);
        HashMap<Character,Integer> lastInd=new HashMap<>();
        lastInd.put('M',0);
        lastInd.put('G',0);
        lastInd.put('P',0);
        int n=travel.length;
        int preSum[]=new int[n+1];
        preSum[0]=0;
        for(int i=0;i<n;i++)
        {
            preSum[i+1]=preSum[i]+travel[i];
        }
        for(int i=0;i<=n;i++)
        {
            String s=garbage[i];
            for(char c:s.toCharArray())
            {
                counter.put(c,counter.get(c)+1);
                lastInd.put(c,i);
            }
        }
        int output=0;
        for(char c:counter.keySet())
        {
            output+=preSum[lastInd.get(c)]+counter.get(c);
        }
        return output;
    }
}