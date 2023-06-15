class Solution {
    public void mergesort(int[] arr,int low,int high)
    {
        if(low<high)
        {
            int mid=low+(high-low)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    public int output;
    void merge(int arr[],int low,int mid,int high)
    {
        int n=mid-low+1;
        int m=high-mid;
        int[] left=new int[n];
        int[] right=new int[m];
        for(int i=0;i<n;i++)
        {
            left[i]=arr[low+i];
        }
        for(int i=0;i<m;i++)
        {
            right[i]=arr[mid+1+i];
        }
        int ptr=0;
        for(int i=0;i<n;i++)
        {
            while(ptr<m && (long)left[i]>(long)2*right[ptr])
            {
                ptr++;
            }
            output+=ptr;
        }
        int k=low,i=0,j=0;
        while(i<n && j<m)
        {
            if(left[i]<=right[j])
            {
                arr[k]=left[i];
                i++;
            }
            else
            {
                arr[k]=right[j];
                j++;
            } 
            k++;
        }
        while(i<n)
        {
            arr[k]=left[i];
            i++;
            k++;
        }
        while(j<m)
        {
            arr[k]=right[j];
            j++;
            k++;
        }
    }
    public int reversePairs(int[] nums) {
        output=0;
        mergesort(nums,0,nums.length-1);
        return output;
    }
}