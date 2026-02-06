// class Solution {
//     public int minRemoval(int[] nums, int k) {
//         Arrays.sort(nums);
//         int left=0;
//         int right=0;
//         int ans=n+1;
//         for(int i =0;i<nums.length;i++){
//             for(int j =0;j<nums.length;j++){
//                 if(nums[i]==nums[j]*k){
//                    ans=Math.max(ans,(nums.length)-2); 
//                 }
//             }
//         }
//         return ans;
        
//     }
// }

import java.util.Arrays;

class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int left = 0;
        int maxSize = 0;

        for (int right = 0; right < n; right++) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }

        return n - maxSize;
    }
}
