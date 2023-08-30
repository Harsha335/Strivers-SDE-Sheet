class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        HashMap<Integer,Long> map=new HashMap<>();   //num,day
        long day=0;
        int n=tasks.length;
        // long output=0;
        for(int i=0;i<n;i++)
        {
            map.putIfAbsent(tasks[i],(long)(-space-1));
            if((day-map.get(tasks[i]))<=space)
            {
                day+=(space-(day-map.get(tasks[i]))+1);
                // output=day;
            }
            map.put(tasks[i],day);
            day++;
            // System.out.println(map);
        }
        return day;
    }
}