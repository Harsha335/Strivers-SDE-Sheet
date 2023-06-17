class Solution {
    int parent[];
    int getparent(int cur){
        if(cur==parent[cur]){
            return cur;
        }
        return getparent(parent[cur]);
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
        // System.out.println(index);
        int ind;
        int maxi=1;
        for(int i=0;i<n;i++){
            int parenty=-1;
            if(index.get(nums[i])!=i)continue;
            int num=nums[i];
            // System.out.println(index.containsKey(num+1));
            if(index.containsKey(num+1)){
                ind=index.get(num+1);
                if(parent[ind]!=i)
                {
                    parenty=getparent(i);
                    // System.out.println(ind+" "+parenty);
                    parent[ind]=i;
                    rank[parenty]+=rank[ind];
                }
            }
            // System.out.println((num-1)+" "+index.containsKey(num-1));
            if(index.containsKey(num-1)){
                ind=index.get(num-1);
                if(parent[i]!=ind)
                {
                    parenty=getparent(ind);
                    parent[i]=ind;
                    rank[parenty]+=rank[i];
                    // System.out.println(parenty+" "+rank[parenty]);
                }
            }
            if(parenty!=-1)
                maxi=Math.max(maxi,rank[parenty]);
            // System.out.println(i+" "+parent[i]+" "+rank[i]);
            // for(int k=0;k<n;k++){
            //     System.out.println(k+" "+parent[k]+" "+rank[k]);
            // }
            // System.out.println();
        }
        return maxi;
    }
}