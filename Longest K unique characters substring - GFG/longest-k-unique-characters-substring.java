//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
       HashMap<Character,Integer> counter=new HashMap<>();
       int i=0;
       int j=0;
       int n=s.length();
       int output=-1;
       while(j<n)
       {
           if(!counter.containsKey(s.charAt(j)) || counter.get(s.charAt(j))==0)
           {
               k--;
               counter.put(s.charAt(j),1);
               while(k<0)
               {
                   counter.put(s.charAt(i),counter.get(s.charAt(i))-1);
                   if(counter.get(s.charAt(i))==0) 
                    k++;
                   i++;
               }
           }
           else counter.put(s.charAt(j),counter.get(s.charAt(j))+1);
        //   System.out.println(i+" "+j+"-"+k);
           if(k==0)
              output=Math.max(output,j-i+1);
           j++;
       }
       return output;
    }
}