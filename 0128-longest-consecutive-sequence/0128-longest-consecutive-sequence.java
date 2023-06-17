class Solution {
    int parent[];
    int getparent(int cur){
        if(cur==parent[cur]){
            return cur;
        }
        return parent[cur]=getparent(parent[cur]);
    }

    public int longestConsecutive(int[] nums) {
        //OR TAKE A ELEMENT AND FIND ITS PARENT THEN COUNT ELEMENTS FROM PARENT ALSO MAKE THEN VISITED REPEATE UNTIL ALL ELEMENTS ARE VISITED
        int n=nums.length;
        if(n<=1)return n;
        parent=new int[n];
        int rank[]=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        HashMap<Integer,Integer> index=new HashMap<>();
        for(int i=0;i<n;i++){
            index.put(nums[i],i);
        }
        int ind;
        int maxi=1;
        for(int i=0;i<n;i++){
            int parenty=-1;
            if(index.get(nums[i])!=i)continue;
            int num=nums[i];
            if(index.containsKey(num+1)){
                ind=index.get(num+1);
                if(parent[ind]==ind) //ind is initail add ro num
                {
                    parenty=getparent(i);
                    parent[ind]=i;
                    rank[parenty]+=rank[ind];
                }
            }
            if(index.containsKey(num-1)){
                ind=index.get(num-1);
                if(parent[i]==i) // i is initail add to num-1
                {
                    parenty=getparent(ind);
                    parent[i]=ind;
                    rank[parenty]+=rank[i];
                }
            }
            if(parenty!=-1)
                maxi=Math.max(maxi,rank[parenty]);
        }
        return maxi;
    }
}