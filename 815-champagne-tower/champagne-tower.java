class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        
        double[][] dp = new double[query_row + 2][query_row + 2];
        dp[0][0] = poured;

        for(int i = 0; i <= query_row; i++){
            for(int j = 0; j <= i; j++){
                
                if(dp[i][j] > 1.0){
                    double excess = (dp[i][j] - 1.0) / 2.0;
                    dp[i+1][j] += excess;
                    dp[i+1][j+1] += excess;
                }
            }
        }

        return Math.min(1.0, dp[query_row][query_glass]);
    }
}

//Recursion
// class Solution {
//     public double champagneTower(int poured, int query_row, int query_glass) {
//         double ans =solve(poured,query_row,query_glass);
//         return Math.min(1.0,ans);
          
//     }
//     public double solve(int poured,int i, int j){
        
//         if(i<0 || j<0 || i<j){
//             return 0.0;
//         }
//         if(i==0 && j==0){
//             return poured;
//         }
//         double left_up = (solve(poured,i-1,j-1)-1)/2.0;
//         double right_up = (solve(poured,i-1,j)-1)/2.0;
//         if(left_up<0){
//             left_up = 0.0;
//         }
//         if(right_up<0){
//             right_up = 0.0;
//         }
//          return left_up+right_up;
//     }
// }