class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        int output=0;
        for(char x:s.toCharArray())
        {
            if(x!=' ')
            {
                count++;
            }
            else if(count!=0){
                output=count;
                count=0;
            }
        }
        return count!=0?count:output;
    }
}