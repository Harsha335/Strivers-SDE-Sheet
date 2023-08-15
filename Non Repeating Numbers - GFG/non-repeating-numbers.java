//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] nums)
    {
        int xor=0;
        for(int ele:nums)
        {
            xor^=ele;
        }
        //finding rightmost 1 of xor
        int rightMost=1;
        while((xor&rightMost)==0) rightMost<<=1;//check next bit
        // System.out.println(rightMost);
        int xor1=0;
        int xor2=0;
        for(int ele:nums)
        {
            if((rightMost&ele)==0)
            {
                xor1^=ele;
            }
            else{   //rightMost&ele!=0
                xor2^=ele;
            }
        }
        return new int[]{Math.min(xor1,xor2),Math.max(xor1,xor2)};
    }
}