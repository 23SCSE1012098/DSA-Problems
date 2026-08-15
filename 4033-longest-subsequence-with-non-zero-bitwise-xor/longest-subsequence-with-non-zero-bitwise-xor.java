// class Solution {
//     public int longestSubsequence(int[] nums) {
//         int n = nums.length;
//         int ans =0;
//         int count=0;
//         if(n==2 && nums[0]!=nums[1]){
//             return n;
//         }
//         else if(n==2  && nums[0]==nums[1]){
//             return 1;
//         }
//         for(int i =0;i<n;i++){
//             ans= ans^nums[i];
//             if(ans>0){
//                 count ++;
//             }

//         }
//         return count ;
        
//     }
// }


class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor=0;
         
        for(int ele :nums){
            if(ele !=0)
            xor^=ele;
        }
        if(xor > 0){
            return n;
        }
        for(int ele:nums){
            if(ele !=0){
                return n-1;
            }
        }
        

        return 0;

        
    }
}