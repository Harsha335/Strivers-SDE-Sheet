class Solution {
    // public boolean isNumeric(String strNum) {
    //     try {
    //         double d = Double.parseDouble(strNum);
    //     } catch (NumberFormatException nfe) {
    //         return false;
    //     }
    //     return true;
    // }
    public int longestValidParentheses(String s) {
        int n=s.length();
        int maxi=0;
        // Stack<String> stack=new Stack<String>();
        // for(int i=0;i<n;i++)
        // {
        //     // System.out.println(i+" "+stack);
        //     if(s.charAt(i)==')')
        //     {
        //         int cur=0;
        //         while(!stack.isEmpty() && isNumeric(stack.peek()))
        //         {
        //             cur+=Integer.parseInt(stack.pop());
        //         }
        //         if(!stack.isEmpty() && stack.peek()=="(")
        //         {
        //             stack.pop();
        //             while(!stack.isEmpty() && isNumeric(stack.peek()))
        //             {
        //                 cur+=Integer.parseInt(stack.pop());
        //             }
        //             maxi=Math.max(maxi,cur+2);
        //             stack.push((cur+2)+"");
        //         }
        //         else{
        //             // stack.push(cur+"");
        //             maxi=Math.max(maxi,cur);
        //             // stack.push(")");
        //             stack.clear();
        //         }
        //     }
        //     else
        //         stack.push("(");
        // }
        // return maxi;
        Stack<Integer> stack=new Stack<>();//index
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)==')')
            {
                if(!stack.isEmpty() && s.charAt(stack.peek())=='(')
                {
                    stack.pop();
                }
                else{
                    stack.push(i);
                }
                maxi=Math.max(maxi,i-(stack.isEmpty()?-1:stack.peek()));
            }
            else{
                stack.push(i);
            }
        }
        return maxi;
    }
}