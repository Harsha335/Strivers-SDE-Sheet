class Solution {
    public int numberOfBeams(String[] bank) {
        int output = 0;
        int pre = 0;
        int len = bank[0].length();
        for(String s: bank)
        {
            int curr = 0;
            for(int i = 0; i<len; i++)
            {
                curr += s.charAt(i)-'0';
            }
            output += curr*pre;
            if(curr != 0)
                pre = curr;
        }
        return output;
    }
}