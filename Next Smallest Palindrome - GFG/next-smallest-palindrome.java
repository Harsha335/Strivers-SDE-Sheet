//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        int temp[]=new int[n];
        
        for(int i=0;i<n/2+n%2;i++)
        {
            temp[i]=num[i];
            temp[n-i-1]=num[i];
        }
        boolean isFound=false;
        for(int i=0;i<n;i++)
        {
            if(temp[i]<num[i])
            {
                break;
            }
            if(temp[i]>num[i])
            {
                isFound=true;
                break;
            }
        }
        if(!isFound)
        {
            for(int i=n/2-1+n%2;i>=0;i--)
            {
                if(!isFound)
                {
                    if(num[i]!=9)
                    {
                        temp[i]=num[i]+1;
                        temp[n-i-1]=num[i]+1;
                        isFound=true;
                    }
                    else{
                        temp[i]=0;
                        temp[n-i-1]=0;
                    }
                }
                else{
                    temp[i]=num[i];
                    temp[n-i-1]=num[i];
                }
            }
        }
        Vector<Integer> output=new Vector<>();
        if(!isFound) output.add(1);
        for(int x:temp)
        {
            output.add(x);
        }
        if(!isFound){
            output.set(n,1);
        }
        return output;
    }
}