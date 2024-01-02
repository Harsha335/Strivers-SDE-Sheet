class Solution {
    private int skip(int ind,List<List<String>> access_times,int n)
    {
        while(ind < n-1)
        {
            if(!access_times.get(ind).get(0).equals(access_times.get(ind+1).get(0)))
                break;
            ind++;
        }
        return ind;
    }
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Collections.sort(access_times,(a,b)->{
            if(a.get(0).equals(b.get(0)))
                return a.get(1).compareTo(b.get(1));
            return a.get(0).compareTo(b.get(0));
        });
        System.out.println(access_times);
        List<String> output = new ArrayList<>();
        int ind = 0;
        int n = access_times.size();
        while(ind+2 < n)
        {
            if(access_times.get(ind).get(0).equals(access_times.get(ind+2).get(0)))
            {
                if(Integer.valueOf(access_times.get(ind).get(1)) > Integer.valueOf(access_times.get(ind+2).get(1))-100)
                {
                    output.add(access_times.get(ind).get(0));
            // System.out.println(ind);
                    ind = skip(ind+2, access_times, n);
            // System.out.println(ind);
                }
            }
            ind++;
        }
        return output;
    }
}