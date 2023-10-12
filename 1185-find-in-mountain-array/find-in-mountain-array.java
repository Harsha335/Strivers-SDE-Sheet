/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    int store[];
    int getPeek(int target, MountainArray mountainArr,int n)
    {
        int low=1,high=n-2;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int out=mountainArr.get(mid);
            int left=mountainArr.get(mid-1);
            int right=mountainArr.get(mid+1);
            store[mid]=out;
            store[mid-1]=left;
            store[mid+1]=right;
            if(left<out && out>right)
            {
                return mid;
            }
            else if(left<out)
            {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
    int leftSubarray(int target, MountainArray mountainArr,int low,int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int out;
            if(store[mid]!=-1)
                out=store[mid];
            else
                out=mountainArr.get(mid);
            if(out==target) 
                return mid;
            if(out<target)
                low=mid+1;
            else
                high=mid-1;
        }
        return -1;
    }
    int rightSubarray(int target, MountainArray mountainArr,int low,int high)
    {
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            int out;
            if(store[mid]!=-1)
                out=store[mid];
            else
                out=mountainArr.get(mid);
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
        store=new int[n];
        Arrays.fill(store,-1);
        int peek=getPeek(target,mountainArr,n);
        int out=leftSubarray(target,mountainArr,0,peek);
        if(out!=-1) 
            return out;
        return rightSubarray(target,mountainArr,peek+1,n-1);
    }
}