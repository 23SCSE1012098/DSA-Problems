// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         int m = dungeon.length;
//         int n = dungeon[0].length;
//         int start=1;
//         int end=40000000;
//         while(start<=end){
//             int mid= (start+end)/2;
            
//             if(solve(dungeon,0,0,mid)){
//                 end = mid;
//             }
//             else{
//                 start=mid+1;
//             }
//         }
//         return start;
    
//     }
    
//     public boolean solve(int dungeon[][],int i,int j , int health){
//         int m = dungeon.length;
//         int n = dungeon[0].length;
//         if(i>m || j>n || health<0){
//             return false;
//         }
//         if(i==m-1 && j==n-1 && health >0){
//             return true;
//         }
//         if(j+1<n){
//             if(solve(dungeon,i,j+1,health+dungeon[i][j+1])) return true;
//         }
//         if(i+1<m){
//             if(solve(dungeon,i+1,j,health+dungeon[i+1][j])) return true;
//         }
//         return false;
//     }
// }
// class Solution {
//     public int calculateMinimumHP(int[][] dungeon) {
//         int m = dungeon.length;
//         int n = dungeon[0].length;
//         return solve(dungeon,0,0); 

//     }
//     public int solve(int [][] dungeon, int i , int j){
//         if(i>=m || j>=n){
//             return false;
//         }
//         if(i==m-1 && j==n-1){
//             return 1+Math.abs(dangeon[i][j]);
//         }
//         int right = solve(i,j+1,dungeon);
//         int down = solve(i+1,j,dungeon);
//         int result = min(right,down)- dungeon[i][j];
//         return result;

//     }
// }
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m][n];

        // Base case: princess cell
        dp[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);

        // Last column
        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, dp[i + 1][n - 1] - dungeon[i][n - 1]);
        }

        // Last row
        for (int j = n - 2; j >= 0; j--) {
            dp[m - 1][j] = Math.max(1, dp[m - 1][j + 1] - dungeon[m - 1][j]);
        }

        // Remaining cells
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int minNext = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, minNext - dungeon[i][j]);
            }
        }

        return dp[0][0];
    }
}
    