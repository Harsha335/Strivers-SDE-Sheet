class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder s=new StringBuilder();
        while(columnNumber>0)
        {
            s.append((char)((columnNumber-1)%26+'A'));
            columnNumber=(columnNumber-1)/26;
        }
        return s.reverse().toString();
    }
}