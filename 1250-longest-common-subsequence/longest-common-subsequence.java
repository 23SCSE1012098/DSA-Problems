// class Solution {
//     int dp[][];
//     public int longestCommonSubsequence(String text1, String text2) {
//         int n = text1.length(), m=text2.length();
//         dp = new int [n+1][m+1];
//         for(int i=0; i<=n; i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return helper(text1,text2,n,m);
//     }
//     int helper(String s1 , String s2 , int n , int m){
//         if(m==0 || n==0) return 0;
//         if(dp[n][m]!=-1) return dp[n][m];
//         if(s1.charAt(n-1)==s2.charAt(m-1)){
//             dp[n][m] =  1 + helper(s1,s2,n-1,m-1);
//         }else{
//             dp[n][m] = Math.max(helper(s1,s2,n-1,m),helper(s1,s2,n,m-1));
//         }
//         return dp[n][m];
//     }
// }

// tabulation 

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m=text2.length();
        int [][] dp = new int [n+1][m+1];
        // for(int i=0; i<=n; i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // for(int i=0; i<=n; i++){
        //     dp[i][m] = 0;
        // }
        // for(int i=0; i<=m; i++){
        //     dp[n][i] = 0;
        // }
        for(int i=1;i<=n;i++){
            for(int j=1; j<=m; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
        return dp[n][m];
    }

}