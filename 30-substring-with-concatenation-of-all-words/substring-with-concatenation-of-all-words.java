class Solution {
    boolean isPossible(String s,int i,int j,HashMap<String,Integer> map,int wordLen)
    {
        while(i<j)
        {
            String sub=s.substring(i,i+wordLen);
            if(map.getOrDefault(sub,0)==0)
                return false;
            map.put(sub,map.get(sub)-1);
            i+=wordLen;
        }
        return i==j;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        int n=s.length();
        int wordLen=words[0].length();
        int len=words.length;
        HashMap<String,Integer> map=new HashMap<>();
        for(String x:words)
        {
            map.put(x,map.getOrDefault(x,0)+1);
        }
        List<Integer> index=new ArrayList<>();
        for(int i=0;i<n-wordLen*len+1;i++)
        {
            if(isPossible(s,i,i+wordLen*len,(HashMap)map.clone(),wordLen))
                index.add(i);
        }
        return index;
    }
}