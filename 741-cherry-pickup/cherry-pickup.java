// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int n = grid.length;
//         int dp [][] = new int [n][n];
//         for(int i=0;i<n;i++){
//             Arrays.fill(dp[i],-1);
//         }
//         dp[0][0] = grid[0][0];
//         for(int i=1;i<n-1;i++){
//             for(int j=1;j<n-1;j++){
//                 if(grid[i][j]==1){
//                     dp[i][j]= Math.max(dp[i-1][j-1]+grid[i][j],dp[i-1][j-1]+grid[i+1][j]);
//                 }
//             }
//         }
//         return dp[n-1][n-1];
        
//     }
// }



class Solution {
    public int n,m;
    public Integer[][][] dp;
    public int cherryPickup(int[][] arr) {
        n=arr.length;
        m=arr[0].length;
        dp=new Integer[n+1][m+1][m+1];
        int ans=solve(arr,0,0,0);
        if(ans==Integer.MIN_VALUE) return 0;
        return ans;
    }
    public int solve(int[][] arr,int r1,int c1,int c2){
        int r2=r1+c1-c2;
        if(r1>n-1 || r2>n-1 || c1>m-1 || c2>m-1 || arr[r1][c1]==-1 || arr[r2][c2]==-1) return Integer.MIN_VALUE;
        if(r1==n-1 && r2==n-1 && c1==m-1 && c2==m-1) return arr[r2][c2];
        if(dp[r1][c1][c2]!=null) return dp[r1][c1][c2];
        int c=0;
        if(r1==r2 && c1==c2) c=arr[r1][c1];
        else c=arr[r1][c1]+arr[r2][c2];
        int dd=solve(arr,r1+1,c1,c2);
        int rd=solve(arr,r1,c1+1,c2);
        int dr=solve(arr,r1+1,c1,c2+1);
        int rr=solve(arr,r1,c1+1,c2+1);
        int max=Math.max(Math.max(dd,rd),Math.max(dr,rr));
        if(max==Integer.MIN_VALUE){
            return dp[r1][c1][c2]=Integer.MIN_VALUE;
        }
        c+=max;
        return dp[r1][c1][c2]=c;
    }
}