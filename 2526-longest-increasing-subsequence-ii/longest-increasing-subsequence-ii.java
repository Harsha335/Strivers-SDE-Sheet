// class Solution {
//     int n;
//     int dp[];
//     int helper(int[] nums,int k,int ind)
//     {
//         if(ind==n)
//             return 0;
//         if(dp[ind]!=-1)
//             return dp[ind];
//         int ans=0;
//         for(int i=ind;i<n;i++)
//         {
//             if(ind==0 || (nums[i]>nums[ind-1] && (nums[i]-nums[ind-1])<=k))
//             {
//                 ans=Math.max(ans,1+helper(nums,k,i+1));
//             }
//         }
//         return dp[ind]=ans;
//     }
//     public int lengthOfLIS(int[] nums, int k) {
//         n=nums.length;
//         dp=new int[n];
//         Arrays.fill(dp,-1);
//         return helper(nums,k,0);
//     }
// }

//@SHASHANK
// class SegmentTree
// {
//     int tree[],n;
//     // int arr[];
//     SegmentTree()
//     {
//         n=100001;
//         // arr=ar;
//         tree=new int[4*n];
//         // build(1,0,n-1);
//     }
//     public int start(int nums[],int k)
//     {
//         int res=0;
//         for(int i : nums)
//         {
//             int ans=query(1,0,n-1,i-k,i-1);
//             // System.out.println(ans);
//             update(1,0,n-1,i,ans+1);
//             res=Math.max(res,ans+1);
//         }
//         return res;
//     }
//     // public void build(int ind,int st,int end)
//     // {
//     //     if(st==end)
//     //     {
//     //         tree[ind]=arr[st];
//     //         return;
//     //     }
//     //     int mid=(st+end)/2;
//     //     build(ind*2,st,mid);
//     //     build(ind*2+1,mid+1,end);
//     //     tree[ind]=Math.max(tree[ind*2],tree[ind*2+1]);
//     // }
//     public int query(int ind,int l,int r,int st,int end)
//     {
        
//         if(l>end || r<st) return Integer.MIN_VALUE;
//         if(l==r) return tree[ind];
//         else if(l>=st && r<=end){
//             return tree[ind];
//         }
//         else
//         {
//             int mid=(l+r)/2;
//             int left=query(ind*2,l,mid,st,end);
//             int right=query(ind*2+1,mid+1,r,st,end);
//             return Math.max(left,right);
//         }
//     }
//     public void update(int node, int start, int end, int pos, int val) 
//     {
//         if (start == end) {
//             // arr[start] = val;
//             tree[node] = val;
//         } else {
//             int mid = (start + end) / 2;
//             if (start <= pos && pos <= mid) {
//                 update(node * 2, start, mid, pos, val);
//             } else {
//                 update(node * 2 + 1, mid + 1, end, pos, val);
//             }
//             tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
//         }
//     }
// }
// class Solution {
//     public int lengthOfLIS(int[] nums, int k) {
//         SegmentTree st=new SegmentTree();
//         return st.start(nums,k);
//     }
// }

class Solution {
    int n;
    int tree[];
    // class SegmentTree{
    //     SegmentTree()
    //     {
    //         tree=new int[4*n];
    //     }
    // }
    int queryMax(int ind,int i,int j,int start,int end)
    {
        if(i>end || j<start)
            return 0;
        if(start<=i && j<=end)
            return tree[ind];
        int mid=i+((j-i)>>1);
        int left=queryMax(ind*2+1,i,mid,start,end);
        int right=queryMax(ind*2+2,mid+1,j,start,end);
        return Math.max(left,right);
    }
    void update(int ind,int i,int j,int pos,int val)
    {
        if(i==j)
        {
            tree[ind]=val;
            return;
        }
        int mid=i+((j-i)>>1);
        if(pos<=mid)
        {
            update(ind*2+1,i,mid,pos,val);
        }
        else{
            update(ind*2+2,mid+1,j,pos,val);
        }
        tree[ind]=Math.max(tree[ind*2+1],tree[ind*2+2]);
    }
    public int lengthOfLIS(int[] nums, int k) {
        // n--maxi+k(range of values)
        n=0;
        for(int x:nums)
        {
            n=Math.max(n,x+k+1);
        }
        tree=new int[4*n+1];
        int output=1;
        for(int x:nums)
        {
            int maxCount=queryMax(0,1,n,x-k,x-1);
            output=Math.max(output,maxCount+1);
            update(0,1,n,x,maxCount+1);
        }
        return output;
    }
}