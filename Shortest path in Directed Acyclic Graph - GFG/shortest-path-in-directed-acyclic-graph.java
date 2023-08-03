//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int n,int M, int[][] edges) {
		int[] dist=new int[n];
		List<List<Integer>> graph[]=new ArrayList[n];
		for(int i=0;i<n;i++)
		{
		    graph[i]=new ArrayList<>();
		}
		for(int[] x:edges)
		{
		    graph[x[0]].add(Arrays.asList(x[1],x[2]));
		}
// 		System.out.println(graph);
		boolean visited[]=new boolean[n];
		PriorityQueue<List<Integer>> pq=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));//dist,vertex
		for(int i=0;i<n;i++)
		{
		    dist[i]=(int)1e9;
		}
		dist[0]=0;
		pq.add(Arrays.asList(0,0));
		while(!pq.isEmpty())
		{
		    int weight=pq.peek().get(0);
		    int vertex=pq.peek().get(1);
		    pq.poll();
		    if(visited[vertex])
		        continue;
		    visited[vertex]=true;
		    for(List<Integer> x:graph[vertex])
		    {
		        if(!visited[x.get(0)] && dist[x.get(0)]>(dist[vertex]+x.get(1)))
		        {
		            dist[x.get(0)]=dist[vertex]+x.get(1);
		            pq.add(Arrays.asList(dist[x.get(0)],x.get(0)));
		        }
		        
		    }
		}
		for(int i=0;i<n;i++)
		{
		    if(dist[i]==(int)1e9) dist[i]=-1;
		}
		return dist;
	}
}