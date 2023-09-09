class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq1=new int[26];
        // int[] freq2=new int[26];
        for(char c1:s1.toCharArray())
        {
            freq1[c1-'a']++;
        }
        int n2=s2.length();
        int n1=s1.length();
        int left=0,right=0;
        while(left<=n2-n1 && right<n2)
        {
            char c=s2.charAt(right);
            if(freq1[c-'a']>0)
            {
                freq1[c-'a']--;
                right++;
            }
            else{
                // while(left!=right)
                // {
                    c=s2.charAt(left);
                    freq1[c-'a']++;
                    left++;
                // }
                // right+=1;
                // left=right;
            }
            // System.out.println(left+" "+right);
            if((right-left)==n1)return true;
        }
        // System.out.println(left+" "+right);
        return false;
    }
}