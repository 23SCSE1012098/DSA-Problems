
class Solution {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        int [][] dp = new int [n][2];
        for(int i=0;i<n;i++){
            dp[i][0]=plantTime[i];
            dp[i][1]=growTime[i];
        }
        Arrays.sort(dp, (a,b) -> b[1] - a[1]);
        int plantingday=0 , Maxtotalday=0;
        for(int i=0;i<n;i++){
            int ptime = dp[i][0];
            int gtime = dp[i][1];

            Maxtotalday = Math.max(Maxtotalday,plantingday+ptime+gtime);
            plantingday = plantingday+ptime;
        }
        return Maxtotalday;
    }
}