class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->{return x[0]-y[0];});
        // for(var x:intervals)
        // {
        //     System.out.println(x[0]+" "+x[1]);
        // }
        List<int[]> out=new ArrayList<>();
        int i=1;
        int n=intervals.length;
        out.add(intervals[0]);
        // int start=-1;
        while(i<n)
        {
            if(out.get(out.size()-1)[1]<intervals[i][0])
            {
                out.add(intervals[i]);
                // start=-1;
            }
            else{
                // if(start)
                out.get(out.size()-1)[1]=Math.max(out.get(out.size()-1)[1],intervals[i][1]);
            }
            i++;
        }
        int output[][]=new int[out.size()][2];
        for(i=0;i<out.size();i++)
        {
            output[i][0]=out.get(i)[0];
            output[i][1]=out.get(i)[1];
        }
        return output;
    }
}