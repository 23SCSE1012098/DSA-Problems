// class Solution {
//     public int maxProfit(int[] prices) {
//         int maxProfit=0;
//         int bestBuy=prices[0];
//         for(int i =1;i<prices.length;i++){
//             if(prices[i]>bestBuy){
//                 maxProfit=Math.max(maxProfit,prices[i]-bestBuy);
//             }
//             bestBuy=Math.min(bestBuy,prices[i]);
//         }
//         return maxProfit;
        
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices) {
//         return solve(0, prices, true); // true = canBuy
//     }

//     public int solve(int index, int[] prices, boolean canBuy) {

        
//         if (index == prices.length) {
//             return 0;
//         }

//         int skip = solve(index + 1, prices, canBuy);

//         if (canBuy) {
            
//             int buy = -prices[index] + solve(index + 1, prices, false);
//             return Math.max(buy, skip);
//         } else {
        
//             int sell = prices[index] + solve(index + 1, prices, true);
//             return Math.max(sell, skip);
//         }
//     }
// }

// class Solution {
//     public int maxProfit(int[] prices) {
//         int n = prices.length;
//         int[][] dp = new int[n][2];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<2;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         return solve(0,1,prices,dp);

//     }
//     public int solve(int i, int flag,int[] prices,int[][] dp){
//         int n = prices.length;
//         if(i>=n) return 0;
//         if(dp[i][flag]!=-1) return dp[i][flag];
//         int Profit=0;
//         if(flag==1){
//             int buy=-prices[i] + solve(i+1,0,prices,dp);
//             int skip = 0 + solve(i+1,1,prices,dp);
//             Profit= Math.max(buy,skip);
            
//         }else{
//             int sell=prices[i] + solve(i+1,1,prices,dp);
//             int skip2 = 0+solve(i+1,0,prices,dp);
//             Profit=Math.max(sell,skip2);
//         }
//         dp[i][flag] = Profit;
//         return dp[i][flag];
//     }
// }


class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
    
        int[][] dp = new int[n + 1][2];


        for (int i = n - 1; i >= 0; i--) {
            for (int flag = 0; flag <= 1; flag++) {

                if (flag == 1) {
                    int buy = -prices[i] + dp[i + 1][0];
                    int skip = dp[i + 1][1];
                    dp[i][1] = Math.max(buy, skip);
                } else {
                    int sell = prices[i] + dp[i + 1][1];
                    int skip = dp[i + 1][0];
                    dp[i][0] = Math.max(sell, skip);
                }
            }
        }

        return dp[0][1];
    }
}
