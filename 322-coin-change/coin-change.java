// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int result = solve(coins, amount);
//         return result == Integer.MAX_VALUE ? -1 : result;
//     }

//     public int solve(int[] coins, int amount) {
//         if (amount == 0) return 0;
//         if (amount < 0) return Integer.MAX_VALUE;

//         int min = Integer.MAX_VALUE;

//         for (int i = 0; i < coins.length; i++) {
//             int ans = solve(coins, amount - coins[i]);
//             if (ans != Integer.MAX_VALUE) {
//                 min = Math.min(min, ans + 1);
//             }
//         }

//         return min;
//     }
// }


// class Solution {
//     int dp [];
//     public int coinChange(int[] coins, int amount) {
//         dp = new int [amount+1];
//         for(int i=0;i<=amount;i++){
//             dp[i]=Integer.MIN_VALUE;
            
//         }
//         int ans =solve(coins,amount);
//         return ans == Integer.MAX_VALUE ? -1 : ans;
        
        
//     }

//     public int solve(int[] coins, int amount) {
//         if (amount == 0) return 0;
//         if (amount < 0) return Integer.MAX_VALUE;
//         if(dp[amount]!=Integer.MIN_VALUE){
//             return dp[amount];
//         }

//         int min = Integer.MAX_VALUE;

//         for (int i = 0; i < coins.length; i++) {
//             int ans = solve(coins, amount - coins[i]);
//             if (ans != Integer.MAX_VALUE) {
//                 min = Math.min(min, ans + 1);
//             }
//         }

//         dp[amount]=min;
//         return min;
//     }
// }



class Solution {

    public int coinChange(int[] coins, int amount) {
        int [] dp = new int [amount+1];
        for(int i=1;i<=amount;i++){
            dp[i]=Integer.MAX_VALUE;
            
        }
        dp[0]=0;
        
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        
        
    }

}




