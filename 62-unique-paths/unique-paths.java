// class Solution {
//     private int totalPaths;

//     public int uniquePaths(int m, int n) {
//         totalPaths = 0;          
//         solve(0, 0, m, n);
//         return totalPaths;
//     }

//     public void solve(int x, int y, int m, int n) {
//         if (x < 0 || y < 0 || x >= m || y >= n) return;

//         if (x == m - 1 && y == n - 1) {
//             totalPaths++;
//             return;
//         }

//         solve(x + 1, y, m, n); 
//         solve(x, y + 1, m, n); 
//     }
// }
class Solution {
    public int uniquePaths(int m, int n){
        int dp[][]=new int [m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}