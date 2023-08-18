class NumArray {
    int[] nums;
    int[] segment;
    public void initalUpdateTree(int ind,int left,int right)
    {
        if(left==right)
        {
            segment[ind]=nums[left];
            return;
        }
        int mid=left+(right-left)/2;
        initalUpdateTree(ind*2+1,left,mid);
        initalUpdateTree(ind*2+2,mid+1,right);
        segment[ind]=segment[ind*2+1]+segment[ind*2+2];
    }
    public NumArray(int[] nums) {
        this.nums=nums;
        segment=new int[4*nums.length];
        initalUpdateTree(0,0,nums.length-1);
    }
    public void updateTree(int ind,int left,int right,int updateInd,int value)
    {
        if(left==right && left==updateInd)
        {
            segment[ind]=value;
            return;
        }
        int mid=left+(right-left)/2;
        if(updateInd<=mid)
        {
            updateTree(ind*2+1,left,mid,updateInd,value);
        }
        else
            updateTree(ind*2+2,mid+1,right,updateInd,value);
        segment[ind]=segment[ind*2+1]+segment[ind*2+2];
    }
    public void update(int index, int val) {
        updateTree(0,0,nums.length-1,index,val);
    }
    public int sum(int ind,int left,int right,int l,int r)
    {
        if(right<l || left>r){
            return 0;
        }
        if(l<=left && r>=right) return segment[ind];

        int mid=left+(right-left)/2;
        return sum(ind*2+1,left,mid,l,r)+sum(ind*2+2,mid+1,right,l,r);
    }
    public int sumRange(int left, int right) {
        return sum(0,0,nums.length-1,left,right);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */