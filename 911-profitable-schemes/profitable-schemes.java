class Solution {
    static int dp [][][] = new int [101][101][101];
    static int mod =(int) 1e9+7;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
            Arrays.fill(dp[i][j], -1);
        }
}
        
        return solve(0,0,0,n,minProfit,group,profit);
   
    }
    public static int solve(int i,int people,int currprofit,int n, int minProfit, int [] group, int [] profit){
        currprofit = Math.min(currprofit,minProfit);
        
        if(i==group.length) return currprofit>=minProfit ? 1 :0;
        if(dp[i][people][currprofit] != -1){
            return dp[i][people][currprofit];
        }
        int take =0;
        if(people +group [i] <=n){
            take = solve(i+1,people+group[i],currprofit+profit[i],n,minProfit,group,profit);
        }
        
        
        int skip = solve(i+1,people,currprofit,n,minProfit,group,profit);
        
        return  dp[i][people][currprofit]=(skip + take)%mod;

    }  
}