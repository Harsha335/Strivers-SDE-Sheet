class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String,Integer> counter=new HashMap<>();
        for(List<String> x:paths)
        {
            counter.put(x.get(0),1);
            if(!counter.containsKey(x.get(1)))
                counter.put(x.get(1),0);
        }
        for(String x:counter.keySet())
        {
            if(counter.get(x)==0)
                return x;
        }
        return "";
    }
}