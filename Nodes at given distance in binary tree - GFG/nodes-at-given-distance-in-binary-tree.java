//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    static ArrayList<Integer> output;
    static int kk;
    static void dfs(Node root,int k)
    {
        if(root==null || k<0)
            return;
        if(k==0)
        {
            output.add(root.data);
        }
        dfs(root.left,k-1);
        dfs(root.right,k-1);
    }
    static boolean helper(Node root,int target)
    {
        if(root==null)
            return false;
        if(root.data==target)
        {
            dfs(root,kk);
            kk-=1;
            return true;
        }
        boolean left=helper(root.left,target);
        if(kk==0)
        {
            output.add(root.data);
            kk-=1;
            return true;
        }
        if(left)
        {
            kk-=1;
            dfs(root.right,kk);
            return true;
        }
        boolean right=helper(root.right,target);
        if(kk==0)
        {
            output.add(root.data);
            kk-=1;
            return true;
        }
        if(right)
        {
            kk-=1;
            dfs(root.left,kk);
            return true;
        }
        return left || right;
    }
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        kk=k;
        output=new ArrayList<>();
       helper(root,target);
       Collections.sort(output);
       return output;
    }
};