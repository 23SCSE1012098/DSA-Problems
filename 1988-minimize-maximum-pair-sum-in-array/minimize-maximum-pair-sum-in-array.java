import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int maxPairSum = 0;
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int pairSum = nums[left] + nums[right];
            maxPairSum = Math.max(maxPairSum, pairSum);
            left++;
            right--;
        }

        return maxPairSum;
    }
}
