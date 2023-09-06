class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out=new ArrayList<>();
        boolean addAll=false;
        for(int[] x:intervals)
        {
            if(addAll)
                out.add(x);
            else if(newInterval[1]<x[0])
            {
                out.add(newInterval);
                out.add(x);
                addAll=true;
                // continue;
            }
            else if(newInterval[0]<=x[1] && x[0]<=newInterval[1])
            {
                newInterval[0]=Math.min(newInterval[0],x[0]);
                newInterval[1]=Math.max(newInterval[1],x[1]);
            }
            else
                out.add(x);

        }
        if(!addAll)
            out.add(newInterval);
        int n=out.size();
        int[][] output=new int[n][2];
        int ind=0;
        for(int[] x:out)
            output[ind++]=x;
        return output;
    }
}