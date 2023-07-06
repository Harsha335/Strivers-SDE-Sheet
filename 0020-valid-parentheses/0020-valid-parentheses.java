class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int n=s.length();
        HashMap<Character,Character> pairs=new HashMap<>();
        pairs.put(']','[');
        pairs.put(')','(');
        pairs.put('}','{');
        // System.out.println(pairs);
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            // System.out.println(c+" "+st);
            if(!pairs.containsKey(c))
            {
                st.add(c);
            }
            else{
                if(st.isEmpty())return false;
                // System.out.println(c+" "+pairs.get('(')+" "+st.peek());
                if(pairs.get(c)!=st.pop())return false;
            }
        }
        // System.out.println(st);
        return st.isEmpty();
    }
}