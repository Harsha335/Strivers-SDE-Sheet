class SubrectangleQueries {
    //USING LAZY TRAVERSAL
    class Ops{
        int r1,c1,r2,c2,val;
        Ops(int r1,int c1,int r2,int c2,int val)
        {
            this.r1=r1;this.c1=c1;this.r2=r2;this.c2=c2;this.val=val;
        }
    }
    List<Ops> l;
    int rect[][];
    public SubrectangleQueries(int[][] rectangle) {
        l=new ArrayList<>();
        rect=rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        l.add(new Ops(row1,col1,row2,col2,newValue));
    }
    
    public int getValue(int row, int col) {
        int n=l.size();
        for(int i=n-1;i>=0;i--)
        {
            if(row>=l.get(i).r1 && row<=l.get(i).r2 && col>=l.get(i).c1 && col<=l.get(i).c2)
                return l.get(i).val;
        }
        return rect[row][col];
    }
}

/**
 * Your SubrectangleQueries object will be instantiated and called as such:
 * SubrectangleQueries obj = new SubrectangleQueries(rectangle);
 * obj.updateSubrectangle(row1,col1,row2,col2,newValue);
 * int param_2 = obj.getValue(row,col);
 */