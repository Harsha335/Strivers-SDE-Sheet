class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int output=0;
        int freq=-1;    //freq ele
        int fcount=0;   //freq count
        int start=0,end=-1; //window range
        HashMap<Integer,Integer> map=new HashMap<>();
        int n=nums.size();
        for(int i=0;i<n;i++)
        {
            end++;
            map.put(nums.get(i),map.getOrDefault(nums.get(i),0)+1);
            if(fcount<map.get(nums.get(i)))
            {
                freq=nums.get(i);
                fcount=map.get(nums.get(i));
            }
            int mis=end-start+1-fcount;
            // System.out.println(start+" "+end+" "+freq+" "+fcount+" "+mis);
            while(mis>k)
            {
                // System.out.println(map+" "+start);
                map.put(nums.get(start),map.get(nums.get(start))-1);
                start++;
                mis=(end-start+1)-fcount;
            }
            output=Math.max(output,fcount);
        }
        return output;
    }
}