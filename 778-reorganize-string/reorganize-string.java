class Solution {
    public String reorganizeString(String s) {
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        int j=1;
        int n=s.length();
        if(n==1) return s;
        while(i+1<n)
        {
            if(sb.charAt(i)==sb.charAt(i+1))
            {
                j=i+2;
                while(j<n)
                {
                    if(sb.charAt(j)!=sb.charAt(i) && (j==n-1 || sb.charAt(j-1)!=sb.charAt(j+1)))
                        break;
                    j++;
                }
                if(j==n) break;
                // System.out.println(sb.toString()+" "+i+" "+j);
                sb.insert(i+1,sb.charAt(j));
                sb=sb.deleteCharAt(j+1);
                i+=1;
            }
            i+=1;
        }
        System.out.println(sb.toString());
        i=n-1;
        while(i>0)
        {
            if(sb.charAt(i)==sb.charAt(i-1))
            {
                // System.out.println(i);
                j=i-2;
                while(j>=0)
                {
                    if(sb.charAt(j)!=sb.charAt(i) && (j==0 || sb.charAt(j-1)!=sb.charAt(j+1)))
                        break;
                    j--;
                }
                // System.out.println(j);
                if(j==-1) return "";
                sb.insert(i,sb.charAt(j));
                sb=sb.deleteCharAt(j);
                i-=1;
            }
            i-=1;
        }
        return sb.toString();
    }
}