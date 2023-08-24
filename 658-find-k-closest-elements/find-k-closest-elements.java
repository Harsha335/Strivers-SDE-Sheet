class Solution {
    int index(int[] arr,int x)
    {
        int i=0;
        int j=arr.length-1;
        int ans=0;
        while(i<=j)
        {
            // System.out.println(i+" "+j);
            int mid=i+(j-i)/2;
            if(Math.abs(arr[ans]-x)>Math.abs(arr[mid]-x))
                ans=mid;
            else if(Math.abs(arr[ans]-x)==Math.abs(arr[mid]-x))
                ans=Math.min(ans,mid);
            if(arr[mid]>x)
            {
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return ans;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int ind=index(arr,x);
        // System.out.println(ind);
        int n=arr.length;
        int i=ind-1;
        int j=ind+1;
        List<Integer> output=new ArrayList<>();
        output.add(arr[ind]);
        k-=1;
        while(k-->0)
        {
            int left=(i==-1?(int)1e9:arr[i]);
            int right=(j==n?(int)1e9:arr[j]);
            // System.out.println(i+" "+j+" "+k);
            // System.out.println(output);
            if(Math.abs(left-x)<=Math.abs(right-x))
            {
                output.add(0,arr[i]);
                i--;
            }
            else{
                output.add(arr[j]);
                j++;
            }
        }
        return output;
    }
}