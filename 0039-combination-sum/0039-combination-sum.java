class Solution {
    List<List<Integer>> output=new ArrayList<>();
    void helper(int[] arr,int ind,int target,int curSum,List<Integer> curList){
        if(curSum==target){
            output.add(new ArrayList<Integer>(curList));
            return;
        }
        if(curSum>target)
            return;
        if(ind==arr.length)
            return;
        helper(arr,ind+1,target,curSum,curList);
        curList.add(arr[ind]);
        helper(arr,ind,target,curSum+arr[ind],curList);
        curList.remove(curList.size()-1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,0,target,0,new ArrayList<Integer>());
        return output;   
    }
}