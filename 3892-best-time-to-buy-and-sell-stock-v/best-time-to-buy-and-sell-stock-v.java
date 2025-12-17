// class Solution {
//     public long maximumProfit(int[] prices, int k) {
        
//     }
// }
class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        // Use long to prevent integer overflow for high profits
        // dp[t][state] 
        // state 0: Neutral, state 1: Long, state 2: Short
        long[][] dp = new long[k + 1][3];

        // Initialize with a very small number, but safe for long operations
        // Long.MIN_VALUE / 2 prevents overflow when subtracting prices
        long INF = Long.MAX_VALUE / 2;

        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;      // Profit starting at Neutral is 0
            dp[i][1] = -INF;   // Impossible to be Long before buying
            dp[i][2] = -INF;   // Impossible to be Short before selling
        }

        for (int price : prices) {
            for (int j = k; j >= 1; j--) {
                
                // Update Neutral (Close a position)
                // Max of (Stay Neutral, Sell Long, Buyback Short)
                dp[j][0] = Math.max(dp[j][0], Math.max(dp[j][1] + price, dp[j][2] - price));

                // Update Long (Open a Long position)
                // Max of (Stay Long, Start Long from previous Neutral)
                dp[j][1] = Math.max(dp[j][1], dp[j-1][0] - price);

                // Update Short (Open a Short position)
                // Max of (Stay Short, Start Short from previous Neutral)
                dp[j][2] = Math.max(dp[j][2], dp[j-1][0] + price);
            }
        }

        long maxProfit = 0;
        for (int j = 0; j <= k; j++) {
            maxProfit = Math.max(maxProfit, dp[j][0]);
        }
        return maxProfit;
    }
}