//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    static ArrayList<String> output;
    static void helper(int[][] matrix,int n,int i,int j,String path)
    {
        if(i==-1 || j==-1 || i==n || j==n)return;
        if(matrix[i][j]!=1)return;
        if(i==j && j==(n-1))
        {
            output.add(new String(path));
            return;
        }
        matrix[i][j]=-1;
        helper(matrix,n,i+1,j,path+"D");
        helper(matrix,n,i,j+1,path+"R");
        helper(matrix,n,i,j-1,path+"L");
        helper(matrix,n,i-1,j,path+"U");
        matrix[i][j]=1;
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        output=new ArrayList<>();
        // if(m[0][0]==0)return
        helper(m,n,0,0,"");
        return output;
    }
}