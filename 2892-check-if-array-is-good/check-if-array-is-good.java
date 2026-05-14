class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        for(int i =0;i<n-2;i++){
            if(nums[i]==nums[i+1]){
                return false;
            }
        }
        int ele = nums[n-1];
        if(n < ele || n > ele+1){
            return false;
        }
        else if (n == ele+1 && nums[n-2]==ele){
            return true;
        }
        return false;
        
    }
}