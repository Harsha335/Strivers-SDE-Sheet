//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            int a[] = new int[(int)(n)];
            int b[] = new int[(int)(m)];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            System.out.println(obj.kthElement( a, b, n, m, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(n>m)
        {
            int[] temp=arr1;
            arr1=arr2;
            arr2=temp;
            int temp1=n;
            n=m;
            m=temp1;
        }
        int i=0;
        int j=Math.min(k,n);
        while(i<=j)
        {
            int mid=(i+j)>>1;
            if((k-mid)>=m)
            {
                mid=k-m;
            }
            int left1=mid==0?-(int)1e9:arr1[mid-1];
            int right1=mid==n?(int)1e9:arr1[mid];
            int mid2=k-mid;
            int left2=mid2==0?-(int)1e9:arr2[mid2-1];
            int right2=mid2==m?(int)1e9:arr2[mid2];
            if(left1<=right2 && left2<=right1)
            {
                return Math.max(left1,left2);
            }
            if(left1>right2) j=mid-1;
            else i=mid+1;
        }
        return arr2[0];
    }
}