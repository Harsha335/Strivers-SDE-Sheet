class Solution {
    private boolean binarySearch(int nums[], int i, int j, int tar){
        while(i<=j){
            int mid = (i+j)>>1;
            if(nums[mid] == tar){
                return true;
            }
            if(nums[mid] < tar){
                i = mid+1;
            }
            else{
                j = mid-1;
            }
        }
        return false;
    }
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;
        for(int i = 0; i< n; i++){
            if(binarySearch(nums, i+1, n-1, k+nums[i])){
                count ++;
            }
            while(i+1<n && nums[i] == nums[i+1]){
                i++;
            }
        }
        return count;
    }
}