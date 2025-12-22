// class Solution {
//     public int change(int amount, int[] coins) {
//         return solve(coins,amount,0);
        
//     }
//     public int solve(int[]coins,int amount, int index){
//         if(amount==0) return 1;
//         if(amount<0 || index==coins.length) return 0;
//         int take =solve(coins,amount-coins[index],index);
//         int nottake =solve(coins,amount,index+1);
//         return take+nottake;
//     }
// }


class Solution {

    public int change(int amount, int[] coins) {
        int[] dp = new int [amount+1];
        dp[0]=1;
        for(int coin : coins){
            for(int i=coin; i<=amount;i++){
                dp[i]+=dp[i-coin];
            }
        }
        return dp[amount];
        
    }
}