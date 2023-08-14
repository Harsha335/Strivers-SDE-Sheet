class Solution {
    List<String> getMoves(String s)
    {
        StringBuilder sb=new StringBuilder(s);
        List<String> output=new ArrayList<>();
        for(int i=0;i<4;i++)
        {
            sb.setCharAt(i,(char)((((sb.charAt(i)-'0')+1)%10)+'0'));    //+1
            output.add(sb.toString());
            sb.setCharAt(i,(char)((((sb.charAt(i)-'0')-2+10)%10)+'0')); //-1
            output.add(sb.toString());
            sb.setCharAt(i,(char)((((sb.charAt(i)-'0')+1)%10)+'0'));    //old state
        }
        return output;
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> q=new LinkedList<>();
        List<String> dead=Arrays.asList(deadends);
        if(!dead.contains("0000"))
            q.add("0000");
        if(target.equals("0000")) return 0;
        int level=0;
        HashSet<String> visited=new HashSet<>();
        visited.add("0000");
        while(!q.isEmpty())
        {
            int size=q.size();
            // System.out.println(q);
            while(size-->0)
            {
                String cur=q.poll();
                for(String x:getMoves(cur))
                {
                    if(x.equals(target)) return level+1;
                    // System.out.println(x+" "+visited);
                    if(!visited.contains(x) && !dead.contains(x))
                    {
                        q.add(x);
                        visited.add(x);
                    }
                }
            }
            level+=1;
        }
        return -1;
    }
}