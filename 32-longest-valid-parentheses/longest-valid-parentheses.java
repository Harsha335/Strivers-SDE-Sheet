class Solution {
    // int helper(String s,Stack<Integer> stack)
    // {
    //     int count=0;
    //     while(stack.size()>=2)
    //     {
    //         if(stack.poll)
    //     }
    // }
    public boolean isNumeric(String strNum) {
    if (strNum == null) {
        return false;
    }
    try {
        double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
        return false;
    }
    return true;
}
    public int longestValidParentheses(String s) {
        int n=s.length();
        int maxi=0;
        Stack<String> stack=new Stack<String>();//index
        for(int i=0;i<n;i++)
        {
            // System.out.println(i+" "+stack);
            if(s.charAt(i)==')')
            {
                int cur=0;
                while(!stack.isEmpty() && isNumeric(stack.peek()))
                {
                    cur+=Integer.parseInt(stack.pop());
                }
                if(!stack.isEmpty() && stack.peek()=="(")
                {
                    stack.pop();
                    maxi=Math.max(maxi,cur+2);
                    stack.push((cur+2)+"");
                }
                else{
                    // stack.push(cur+"");
                    maxi=Math.max(maxi,cur);
                    // stack.push(")");
                    stack.clear();
                }
            }
            else
                stack.push("(");
        }
        // int cur=0;
        // System.out.println(stack);
        while(!stack.isEmpty())
        {
            if(stack.peek()==")" || stack.peek()=="(") stack.pop();
            int cur=0;
            while(!stack.isEmpty() && isNumeric(stack.peek()))
                cur+=Integer.parseInt(stack.pop());
            maxi=Math.max(cur,maxi);
        }
        return maxi;
    }
}