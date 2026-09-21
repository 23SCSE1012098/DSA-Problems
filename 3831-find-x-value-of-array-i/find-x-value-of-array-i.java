class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] ans = new long[k];

        // dp[r] = number of subarrays ending at previous index
        // whose product % k == r
        long[] dp = new long[k];

        for (int num : nums) {

            long[] newDp = new long[k];

            // Subarray containing only num
            int single = num % k;
            newDp[single]++;

            // Extend every previous subarray
            for (int r = 0; r < k; r++) {

                if (dp[r] > 0) {
                    int newRemainder = (r * single) % k;

                    newDp[newRemainder] += dp[r];
                }
            }

            // Add current subarrays to final answer
            for (int r = 0; r < k; r++) {
                ans[r] += newDp[r];
            }

            // Move current DP to next iteration
            dp = newDp;
        }

        return ans;
    }
}