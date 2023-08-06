class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i:hand)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(int i:map.keySet()) 
        {
            if(map.get(i)==0) continue;
            int times=map.get(i);   // ITERATE UTIL I BECOMES 0
            map.put(i,map.get(i)-times);
            for(int num=i+1;num<(i+groupSize);num++)
            {
                if(map.getOrDefault(num,0)==0)
                {
                    // break;
                    return false;
                }
                map.put(num,map.get(num)-times);    // RETURN BACK VALUES IF NOT POSSIBLE
            }
            // if(count==groupSize) return true;   //WRONG RETURNING READ QUESION
        }
        // return false;
        return true;
    }
}