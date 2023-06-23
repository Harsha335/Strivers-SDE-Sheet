class Solution {
    List<List<Integer>> output=new ArrayList<>();
    void helper(int[] arr,int ind,int target,int cur,List<Integer> curArr){
        if(ind==arr.length)
        {
            if(cur==target){
                output.add(new ArrayList<Integer>(curArr));
            }
            return;
        }
        if(cur+arr[ind]<=target)
        {
            curArr.add(arr[ind]);
            helper(arr,ind+1,target,cur+arr[ind],curArr);
            curArr.remove(curArr.size()-1);
            while(ind+1<arr.length && arr[ind]==arr[ind+1]){
                ind++;
            }
        }
        helper(arr,ind+1,target,cur,curArr);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,0,target,0,new ArrayList<Integer>());
        return output;
    }
}