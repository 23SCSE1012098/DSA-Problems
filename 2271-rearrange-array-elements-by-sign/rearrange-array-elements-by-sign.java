class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[] = new int [nums.length];
        int positive =0;
        int negative =1;
        for(int x:nums){
            if(x>0){
                ans[positive]=x;
                positive+=2;
            }
            if(x<0){
                ans[negative]=x;
                negative+=2;
            }
        }
        return ans;
    }
}