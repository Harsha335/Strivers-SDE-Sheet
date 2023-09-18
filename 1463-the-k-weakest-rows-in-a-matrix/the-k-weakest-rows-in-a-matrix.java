class Solution {
    private int binarySearch(int arr[],int n)
    {
        int i=0;
        int j=n-1;
        int ans=n;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(arr[mid]==1)
            {
                i=mid+1;
            }
            else{
                ans=mid;
                j=mid-1;
            }
        }
        return n-ans;
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int count[]=new int[m];
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->{
            if(count[a]==count[b])return a-b;
            else return count[b]-count[a];
            }
        );
        int ind=0;
        for(int x[]:mat)
        {
            count[ind]=binarySearch(x,n);
            // System.out.println(ind+" "+count[ind]);
            pq.add(ind++);
        }
        int output[]=new int[k];
        for(int i=0;i<k;i++)
        {
            output[i]=pq.poll();
        }
        return output;
    }
}