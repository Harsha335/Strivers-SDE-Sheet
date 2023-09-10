class Solution {
    public int calculate(String s) {
        int ans=0,sign=1,num=0;
        int n=s.length();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                num=num*10+(c-'0');
            }
            else if(c=='+')
            {
                ans+=(num*sign);
                num=0;
                sign=1;
            }
            else if(c=='-')
            {
                ans+=(num*sign);
                num=0;
                sign=-1;
            }
            else if(c=='(')
            {
                st.add(ans);
                st.add(sign);
                ans=0;
                sign=1;
            }
            else if(c==')'){
                ans+=(num*sign);
                num=0;
                sign=1;
                ans*=st.pop();
                ans+=st.pop();
            }
        }
        if(num!=0)
        {
            ans+=(num*sign);
        }
        return ans;



        // HashSet<Character> op=new HashSet<>();
        // op.add('+');
        // op.add('-');
        // char ch=s.charAt(0);
        // if(ch=='-')
        // {
        //     s="0"+s;
        // }
        // int n=s.length();
        // Stack<Character> stack=new Stack<>();
        // StringBuilder postfix=new StringBuilder();
        
        // for(char c:s.toCharArray())
        // {
        //     if(Character.isDigit(c))
        //     {
        //         postfix.append(c);
        //     }
        //     else if(c==')')
        //     {
        //         while(!stack.isEmpty())
        //         {
        //             ch=stack.pop();
        //             if(ch=='(')
        //                 break;
        //             postfix.append(ch);
        //         }
        //     }
        //     else{   //c== '(' || '+' || '-' || ' '
        //         postfix.append(' ');//sperate digits
        //         while(!stack.isEmpty() && (c=='(' || stack.peek()!='('))
        //             postfix.append(stack.pop());
                
        //         stack.push(c);
        //     }
        // }
        // while(!stack.isEmpty())
        //     postfix.append(stack.pop());
        // String ss=postfix.toString();
        // Stack<String> st=new Stack<>();
        // String digit="";
        // System.out.println(ss);
        // for(char c:ss.toCharArray())
        // {
        //     if(Character.isDigit(c))
        //     {
        //         digit+=c;
        //     }
        //     else if(c==' '){
        //         if(digit!="")
        //         {
        //             st.push(digit);
        //             digit="";
        //         }
        //     }
        //     else
        //     {
        //         if(digit!="")
        //         {
        //             st.push(digit);
        //             digit="";
        //         }
        //         int n1=Integer.parseInt(st.pop());
        //         int n2=Integer.parseInt(st.pop());
        //         if(c=='+')
        //             st.push((n2+n1)+"");
        //         else
        //             st.push((n2-n1)+"");
        //     }
        // }
        // if(digit!="")
        //     st.push(digit);
        // return Integer.parseInt(st.pop());
    }
}