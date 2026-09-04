class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int [] minarr = new int [n];
        int min=Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--){
            min=Math.min(nums[i],min);
            minarr[i]=min;

        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if((max-minarr[i])<=k){
                return i;
            }
        }
        return -1;
        
    }
}