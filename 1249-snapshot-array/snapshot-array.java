class SnapshotArray {
    int snap;
    int arr[];
    List<List<Integer>> snaps[];//index-List(snapid,val)
    public SnapshotArray(int length) {
        snap=-1;
        arr=new int[length];
        snaps=new ArrayList[length];
        for(int i=0;i<length;i++)
        {
            snaps[i]=new ArrayList<>();
        }
    }
    
    public void set(int index, int val) {
        int len=snaps[index].size();
        if(len==0 || snaps[index].get(len-1).get(0)!=snap+1)// && value!=.......)
        {
            snaps[index].add(Arrays.asList(snap+1,val));
        }
        else{
            snaps[index].get(len-1).set(1,val);
        }
        arr[index]=val;
    }
    
    public int snap() {
        snap+=1;
        // for(int x:arr)
        // System.out.println(x);
        // snaps.add(arr.clone());
        return snap;
    }
    private int binarySearch(List<List<Integer>> arr,int id)
    {
        int len=arr.size();
        int i=0,j=len-1;
        int ans=-1;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(arr.get(mid).get(0)==id)
                return mid;
            if(arr.get(mid).get(0)<id)
            {
                ans=mid;
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }
        return ans;
    }
    public int get(int index, int snap_id) {
        // for(int[] x:snaps)
        // {
        //     for(int ele:x)
        //     System.out.println(ele);
        // }
        int ind=binarySearch(snaps[index],snap_id);
        if(ind==-1)
            return 0;
        return snaps[index].get(ind).get(1);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */