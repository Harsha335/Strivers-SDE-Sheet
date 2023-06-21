//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    ArrayList<Integer> output;
    void helper(ArrayList<Integer> arr,int n,int ind,int cur)
    {
        // if(cur!=0)
        if(n==ind)
        {
            output.add(cur);
            return;
        }
        helper(arr,n,ind+1,cur+arr.get(ind));
        // if(ind!=0)
        helper(arr,n,ind+1,cur);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        output=new ArrayList<>();
        // output.add(0);
        helper(arr,N,0,0);
        
        return output;
    }
}