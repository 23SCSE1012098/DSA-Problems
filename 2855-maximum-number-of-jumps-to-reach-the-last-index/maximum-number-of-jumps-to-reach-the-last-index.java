class Solution {

    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        int[] ans = new int[n];

        Arrays.fill(ans, -1);

        ans[0] = 0;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (Math.abs(nums[i] - nums[j]) <= target && ans[j] != -1) {

                    ans[i] = Math.max(ans[i], ans[j] + 1);
                }
            }
        }

        return ans[n - 1];
    }
}