// class Solution {
//     public int findDuplicate(int[] nums) {
        
//     }
// }
class Solution {
    public int findDuplicate(int[] nums) {

        int ans = 0;

        // Step 1: Find the duplicate number
        for (int i = 0; i < nums.length; i++) {

            int ele = Math.abs(nums[i]); // get absolute value

            if (nums[ele] > 0) {
                // mark as visited
                nums[ele] = -nums[ele];
            } else {
                // duplicate found
                ans = ele;
                break;
            }
        }

        // Step 2: Restore the array (optional but good practice)
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return ans;
    }
}