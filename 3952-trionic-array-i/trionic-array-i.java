class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p = 0;

        // 1) Move p while strictly increasing
        while (p < n - 2 && nums[p] < nums[p + 1]) {
            p++;
        }
        // If no increase at start
        if (p == 0) {
            return false;
        }

        int q = p;
        // 2) Move q while strictly decreasing
        while (q < n - 1 && nums[q] > nums[q + 1]) {
            q++;
        }
        // No decreasing section or no room for last increase
        if (q == p || q == n - 1) {
            return false;
        }

        // 3) Check final strictly increasing part
        while (q < n - 1 && nums[q] < nums[q + 1]) {
            q++;
        }

        // Must reach end to be valid
        return q == n - 1;
    }
}