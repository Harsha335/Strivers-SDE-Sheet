//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    ArrayList<String> output;
    void swap(char[] chr,int i,int j)
    {
        char c=chr[i];
        chr[i]=chr[j];
        chr[j]=c;
    }
    void helper(char[] chr,int ind,int n)
    {
        if(ind==n){
            output.add(new String(chr));
            return;
        }
        for(int i=ind;i<n;i++)
        {
            swap(chr,ind,i);
            // System.out.println((new String(chr))+" "+ind+" "+i);
            helper(chr,ind+1,n);
            swap(chr,ind,i);
        }
    }
    public ArrayList<String> permutation(String s)
    {
        output=new ArrayList<>();
        int n=s.length();
        // for(int i=0;i<n;i++)
        helper(s.toCharArray(),0,n);
        Collections.sort(output);
        return output;
    }
	   
}
