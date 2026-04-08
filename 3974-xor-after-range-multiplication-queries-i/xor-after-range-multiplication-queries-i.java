class Solution {
    
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod = 1000000000+7;

        for(int [] query : queries){
            int start = query[0];
            int end = query[1];
            int incre = query[2];
            int multi = query[3];
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