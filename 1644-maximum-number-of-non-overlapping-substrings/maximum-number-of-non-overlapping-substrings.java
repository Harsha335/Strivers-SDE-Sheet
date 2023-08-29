class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] start=new int[26];
        int[] end=new int[26];
        Arrays.fill(start,-1);
        // Arrays.fill(end,-1);
        int n=s.length();
        int uniqueCount=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(start[c-'a']==-1)
            {
                start[c-'a']=i;
                end[c-'a']=i;
                uniqueCount++;
            }
            else{
                end[c-'a']=i;
            }
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int range[][]=new int[uniqueCount][2];
        int ind=0;
        for(int i=0;i<26;i++)
        {
            if(start[i]!=-1)
            {
                range[ind][0]=start[i];
                range[ind++][1]=end[i];
            }
        }
        Arrays.sort(range,(a,b)->a[0]-b[0]);
        List<String> output=new ArrayList<>();
        int oldRight=-1;
        for(int i=0;i<uniqueCount;i++)
        {
            int left=range[i][0];
            int right=range[i][1];
            // System.out.println(left+" "+right);
            right=newRight(s,left,right,start,end);
            if(right!=-1)
            {
            // System.out.println(left+" "+right);
                if(right<=oldRight)
                {
                    output.set(output.size()-1,s.substring(left,right+1));
                }
                else{
                    output.add(s.substring(left,right+1));
                }
                oldRight=right;
            }
        }
        return output;
    }
    int newRight(String s,int left,int right,int[] start,int end[])
    {
        int r=right;
        // System.out.println(left);
        for(int i=left;i<=right;i++)
        {
            // System.out.println(start[s.charAt(i)-'a']+" "+s.charAt(i));
            if(start[s.charAt(i)-'a']<left) return -1;
            right=Math.max(right,end[s.charAt(i)-'a']);
        }
        return right;
    }
}