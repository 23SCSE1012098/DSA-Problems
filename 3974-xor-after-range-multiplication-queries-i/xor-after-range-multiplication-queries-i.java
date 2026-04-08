class Solution {
    
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000000+7;

        for(int k=0;k < queries.length;k++){
            int start = queries[k][0];
            int end = queries[k][1];
            int incre = queries[k][2];
            int multi = queries[k][3];
            for(int i=start; i<=end;i+=incre){
                nums[i]=(int)((1L * nums[i]*multi)%mod);
            }
        }
        int xor =0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];

        }
        return xor;
    }
} 