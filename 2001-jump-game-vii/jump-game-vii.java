// class Solution {
//     Boolean dp [];
//     public boolean canReach(String s, int minJump, int maxJump) {
//         int n = s.length();
//         dp = new Boolean [n];
//         return solve(0,s.length(),s,minJump, maxJump);

        
//     }
//     public boolean solve (int i ,int n ,String s , int minJump, int maxJump){
//         if(i==n-1){
//             return true;
//         }
        
//         if(dp[i]!=null){
//             return dp[i];
//         }
        
//         for(int jump=minJump;jump<=maxJump;jump++){
//             int j = i+jump;
//             if(j>=n) break;
//             if(s.charAt(j)=='0'){
//                 if(solve(j,n,s,minJump,maxJump)){
//                     return dp[i]=true;
//                 }
//             }

//         }
//         return dp[i] =false;
//     }
// }


class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        boolean[] dp = new boolean[n];

        dp[0] = true;

        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // add new index entering window
            if (i - minJump >= 0 && dp[i - minJump]) {
                reachable++;
            }

            // remove old index leaving window
            if (i - maxJump - 1 >= 0 && dp[i - maxJump - 1]) {
                reachable--;
            }

            // current position reachable
            if (reachable > 0 && s.charAt(i) == '0') {
                dp[i] = true;
            }
        }

        return dp[n - 1];
    }
}