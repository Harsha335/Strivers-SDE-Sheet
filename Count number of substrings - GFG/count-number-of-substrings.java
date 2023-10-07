//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    long atmostK(String s, int k)
    {
        int n=s.length();
        int i=0,j=0;
        int freq[]=new int[26];
        Arrays.fill(freq,-1);
        int count=0;
        int output=0;
        while(j<n)
        {
            if(freq[s.charAt(j)-'a']==-1)
                count+=1;
            freq[s.charAt(j)-'a']=j;
            while(count>k)
            {
                if(i==freq[s.charAt(i)-'a'])
                {
                    count--;
                    freq[s.charAt(i)-'a']=-1;
                }
                i++;
            }
            output+=(j-i)+1;
            j++;
        }
        return output;
    }
    long substrCount (String S, int K) {
        return atmostK(S,K)-atmostK(S,K-1);   
    }
}