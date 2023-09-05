class Solution {
    boolean helper(String s,String t,int i,int j)
    {
        if(i==-1)
            return true;
        if(j==-1)
            return false;
        if(s.charAt(i)==t.charAt(j))
            return helper(s,t,i-1,j-1);
                // return true;
        return helper(s,t,i,j-1);
    }
    public boolean isSubsequence(String s, String t) {
        return helper(s,t,s.length()-1,t.length()-1);
    }
}