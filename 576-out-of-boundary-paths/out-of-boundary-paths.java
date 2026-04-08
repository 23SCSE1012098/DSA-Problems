class Solution {
    static int mod =1000000000+7;
    static int [][][] dp ;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp = new int [52][52][52];
        for(int i=0;i<52;i++){
            for(int j=0;j<52;j++){
                for(int k=0;k<52;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return  (solve(startRow,startColumn,0,maxMove,m , n))%mod;

        
    }
    public static int solve(int i, int j , int move,int maxMove,int m , int n){
        if(i<0 || i>=m || j<0 || j>=n){
            return 1;
        }
        if(move==maxMove || maxMove==0){
            return 0;
        }
        if(dp[i][j][move]!=-1){
            return dp[i][j][move];
        }
        long Ans =0;
        Ans +=solve(i+1,j,move+1,maxMove, m, n);
        Ans +=solve(i,j+1,move+1,maxMove,m,n);
        Ans +=solve(i-1,j,move+1,maxMove,m,n);
        Ans +=solve(i,j-1,move+1,maxMove,m,n);
        return dp[i][j][move]= (int) (Ans%mod);
    }
}