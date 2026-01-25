// class Solution {
//     public int minimumDifference(int[] nums, int k) {
//         Arrays.sort(nums);
//         int minimum=Integer.MAX_VALUE;
//         int start=0;
//         int end=nums.length-1;
//         while(start>=0 || end<nums.length ){
//             int dis=nums[start]-nums[end];
//             if(dis < minimum){
//                 minimum=dis;
//             }
//         }
//         start++;
//         end--;
//         return minimum;

        
//     }
// }

import java.util.Arrays;

class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;

        Arrays.sort(nums);
        int minimum = Integer.MAX_VALUE;

        for (int i = 0; i + k - 1 < nums.length; i++) {
            int diff = nums[i + k - 1] - nums[i];
            minimum = Math.min(minimum, diff);
        }

        return minimum;
    }
}
