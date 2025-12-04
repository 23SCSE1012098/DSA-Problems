// class Solution {
//     public int climbStairs(int n) {
//         if(n<=2){
//             return n;
//         }
//         int dp[]=new int[n+1];
//         dp[1]=1;
//         dp[2]=2;
//         for(int i=3;i<=n;i++){
//             dp[i]=dp[i-1]+dp[i-2];

//         }
//         return dp[n];
        
        
//     }
// }
// class Solution {
//     public int climbStairs(int n) {
//         if(n==0){
//             return 1;
//         }
//         if(n==1){
//             return 1;
//         }
//         int dp[]=new int[n+1];
//         Arrays.fill(dp, -1);
//         if(dp[n]!=-1){
//             return dp[n];
//         }
//         dp[n] = climbStairs(n-1)+climbStairs(n-2);
//         return dp[n];
//     }
// }

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climb(n, dp);
    }

    private int climb(int n, int[] dp) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        dp[n] = climb(n-1, dp) + climb(n-2, dp);
        return dp[n];
    }
}
