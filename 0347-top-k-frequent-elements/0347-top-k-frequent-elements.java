class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            // map.putIfAbsent(i,0);
            map.put(i,map.getOrDefault(i,0)+1);
        }
        // System.out.println(map);
        PriorityQueue<List<Integer>> p=new PriorityQueue<>((a,b)->{
            return b.get(1)-a.get(1);
        });
        for(Integer i:map.keySet()){
            // List<Integer> l=new ArrayList<>();
            // l.add(i);
            // l.add(map.get(i));
            // p.add(new ArrayList<>(l));
            p.add(Arrays.asList(i,map.get(i)));
        }
        // System.out.println(p);
        // ArrayList<Integer> output=new ArrayList<>();
        int output[]=new int[k];
        for(int i=0;i<k;i++){
            output[i]=p.poll().get(0);
        }
        return output;
    }
}