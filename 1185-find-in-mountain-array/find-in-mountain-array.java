/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    int[] getPeek(int target, MountainArray mountainArr,int n)
    {
        int low=0,high=n-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int out=mountainArr.get(mid);
            // System.out.println(low+" "+high);
            // if(out==target)
            // {
            //     return new int[]{mid,out};
            // }
            int left=mid-1==-1?-1:mountainArr.get(mid-1);
            // if(left==target)
            // {
            //     return new int[]{mid-1,left};
            // }
            int right=mid+1==n?Integer.MAX_VALUE:mountainArr.get(mid+1);
            // if(right==target)
            // {
            //     return new int[]{mid+1,right};
            // }
            // System.out.println(left+" "+right+" "+target);

            if(left<out && out>right)
            {
                return new int[]{mid,out};
            }
            else if(left<out)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return new int[]{-1,-1};
    }
    int helper(int target, MountainArray mountainArr,int low,int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int out=mountainArr.get(mid);
            if(out==target) return mid;
            if(out<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    int helper2(int target, MountainArray mountainArr,int low,int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int out=mountainArr.get(mid);
            if(out==target) return mid;
            if(out<target)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n=mountainArr.length();
        // System.out.println("hi");
        int[] l=getPeek(target,mountainArr,n);
        int ind=l[0],ele=l[1];
        // System.out.println(ind+" "+ele);
        if(ele==target) return ind;
        int out=helper(target,mountainArr,0,ind-1);
        if(out!=-1) return out;
        out=helper2(target,mountainArr,ind+1,n-1);
        if(out!=-1) return out;
        return -1;
    }
}