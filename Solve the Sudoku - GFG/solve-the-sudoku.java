//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class
{
    public static void main(String args[])
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int grid[][] = new int[9][9];
            for(int i = 0; i < 9; i++)
            {
                for(int j = 0; j < 9; j++)
                grid[i][j] = sc.nextInt();
            }
            
            Solution ob = new Solution();
            
            if(ob.SolveSudoku(grid) == true)
                ob.printGrid(grid);
            else
                System.out.print("NO solution exists");
            System.out.println();
            
        }
    }
}




// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean isOk(int[][] grid,int i,int j,int ele)
    {
        for(int ind=0;ind<9;ind++)
        {
            // System.out.println(grid[i][ind]+" "+grid[ind][j]);
            if(grid[i][ind]==ele) return false;
            if(grid[ind][j]==ele) return false;
        }
        int startI=(int)Math.floor(i/3)*3;
        int startJ=(int)Math.floor(j/3)*3;
        for(int ii=startI;ii<startI+3;ii++)
        {
            for(int jj=startJ;jj<startJ+3;jj++)
            {
                if(grid[ii][jj]==ele) return false;
            }
        }
        return true;
    }
    static boolean helper(int[][] grid,int ii,int jj)
    {
        // System.out.println(ii+" "+jj);
        for(int i=ii;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(grid[i][j]==0)
                {
                    for(int ele=1;ele<=9;ele++)
                    {
                            // System.out.println(ele+" "+i+" "+j);
                        if(isOk(grid,i,j,ele))
                        {
                            grid[i][j]=ele;
                            // if(j==8) if(helper(grid,i+1,0)) return true;
                            // else
                            if(helper(grid,i,j)) return true;
                            grid[i][j]=0;
                        }
                    }
                    // System.out.println(i+" "+j+" false");
                    return false;
                }
            }
        }
        return true;
    }
    static boolean SolveSudoku(int grid[][])
    {
        return helper(grid,0,0);
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                System.out.print(grid[i][j]+" ");
            }
            // System.out.println();
        }
    }
}