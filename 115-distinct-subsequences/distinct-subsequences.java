// class Solution {
//     int [][] dp;
//     public int numDistinct(String s, String t) {
//         int m = s.length();
//         int n = t.length();
//         dp=new int [m][n];
//         for(int i=0;i<m;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         return solve(s,t,0,0);
        
//     }
//     int solve (String s, String t, int i, int j){
//         if(j==t.length()){
//             return 1;
//         }
//         if(i==s.length()){
//             return 0;
//         }
//         if(dp[i][j]!=-1){
//             return dp[i][j];
//         }
//         if(s.charAt(i)==t.charAt(j)){
//             dp[i][j] = solve(s,t,i+1,j+1)+solve(s,t,i+1,j);
//         }
//         else{
//             dp[i][j]= solve(s,t,i+1,j);
//         }
//         return dp[i][j];
//     }
// }


class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int dp [][] = new int [n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=1;j<=m;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}