class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        // TreeMap<Integer,Integer> map=new TreeMap<>();//ele,count
        TreeSet<Integer> set=new TreeSet<>();//ele,count
        int n=nums.size();
        int mini=(int)1e9;
        for(int i=x;i<n;i++)
        {
            // map.put(nums.get(i-x),1);
            // Integer lower=map.floorKey(nums.get(i));    //lowerKey < & floorKey <=
            // if(lower!=null) mini=Math.min(mini,nums.get(i)-lower);
            // Integer upper=map.ceilingKey(nums.get(i));     //higherKey > & ceilingKey >=
            // if(upper!=null) mini=Math.min(mini,upper-nums.get(i));
            // System.out.println(i+" "+lower+" "+upper);

            set.add(nums.get(i-x));
            Integer lower=set.floor(nums.get(i));
            if(lower!=null)
                mini=Math.min(mini,nums.get(i)-lower);
            Integer upper=set.ceiling(nums.get(i));
            if(upper!=null)
                mini=Math.min(mini,upper-nums.get(i));
        }
        return mini;
    }
}