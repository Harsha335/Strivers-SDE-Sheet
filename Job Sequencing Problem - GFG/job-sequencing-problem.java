//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends

class Solution 
{
    class Compare implements Comparator<Job>
    {
        // @Override
        public int compare(Job o1,Job o2)
        {
            if(o1.profit<o2.profit)return 1;
            if(o1.profit>o2.profit)return -1;
            return 0;
        }   
    }
    int getparent(int cur,int parent[])
    {
        if(cur==parent[cur])return cur;
        return parent[cur]=getparent(parent[cur],parent);
    }
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,new Compare());
        // ,new Comparator<Job>(){
        //     @Override
        //     public int compare(Job o1,Job o2)
        //     {
        //         if(o1.profit<o2.profit)return 1;
        //         if(o1.profit>o2.profit)return -1;
        //         return 0;
        //     }
        // });
        int size=0;
        for(Job x:arr)
        {
            // System.out.println(x.id+" "+x.deadline+" "+x.profit);
            size=Math.max(x.deadline,size);
        }
        int seq[]=new int[size+1];
        
        for(int i=0;i<=size;i++)
        {
            seq[i]=i;
        }
        int count=0,cost=0;
        for(Job x:arr)
        {
            int parent=getparent(x.deadline,seq);
            if(parent==0)continue;
            count++;
            cost+=x.profit;
            seq[parent]=parent-1;
        }
        return new int[]{count,cost};
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/