// class Solution {
//     public int maxProfit(int[] prices) {
//         return solve(0, prices, true, 2); // 2 transactions allowed
//     }

//     public int solve(int index, int[] prices, boolean canBuy, int cap) {

//         // Base cases
//         if (index == prices.length || cap == 0) {
//             return 0;
//         }

//         // Skip
//         int skip = solve(index + 1, prices, canBuy, cap);

//         if (canBuy) {
//             // Buy
//             int buy = -prices[index] + solve(index + 1, prices, false, cap);
//             return Math.max(buy, skip);
//         } else {
//             // Sell (transaction completes here)
//             int sell = prices[index] + solve(index + 1, prices, true, cap - 1);
//             return Math.max(sell, skip);
//         }
//     }
// }

// memoization

// class Solution {
//     int[][][] dp;

//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         dp = new int[n][2][3];

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 2; j++) {
//                 for (int k = 0; k < 3; k++) {
//                     dp[i][j][k] = -1;
//                 }
//             }
//         }

//         return solve(0, prices, 1, 2);
//     }

//     public int solve(int index, int[] prices, int canBuy, int cap) {

//         if (index == prices.length || cap == 0) {
//             return 0;
//         }

//         if (dp[index][canBuy][cap] != -1) {
//             return dp[index][canBuy][cap];
//         }

//         int skip = solve(index + 1, prices, canBuy, cap);
//         int profit;

//         if (canBuy == 1) {
//             int buy = -prices[index] + solve(index + 1, prices, 0, cap);
//             profit = Math.max(buy, skip);
//         } else {
//             int sell = prices[index] + solve(index + 1, prices, 1, cap - 1);
//             profit = Math.max(sell, skip);
//         }

//         return dp[index][canBuy][cap] = profit;
//     }
// }


// Tabulation 

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        for (int index = n - 1; index >= 0; index--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (canBuy == 1) {
                        dp[index][canBuy][cap] =
                            Math.max(-prices[index] + dp[index + 1][0][cap],
                                      dp[index + 1][1][cap]);
                    } else {
                        dp[index][canBuy][cap] =
                            Math.max(prices[index] + dp[index + 1][1][cap - 1],
                                      dp[index + 1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}

