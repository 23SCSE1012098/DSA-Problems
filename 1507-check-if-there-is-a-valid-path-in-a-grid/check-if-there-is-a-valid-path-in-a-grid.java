// class Solution {
//     public boolean hasValidPath(int[][] grid) {
//           int n = grid.length;
//           int m = grid[0].length;
//           boolean [][] visited = new boolean [n][m];
//           dfs(0,0,n,m,grid,visited);
//           return visited[n-1][m-1];

        
//     }
//     public static void dfs (int i , int j , int n , int m ,int [][] grid, boolean [][] visited){
//         if(i<0 || j<0 || i>=n || j>=m || visited [i][j]) return ;
//         visited[i][j]=true;

//         if(grid[i][j]==1){
//             dfs(i,j-1,n,m,grid,visited);
//             dfs(i,j+1,n,m,grid,visited);
//         }
//         else if(grid[i][j]==2){
//             dfs(i-1,j,n,m,grid,visited);
//             dfs(i+1,j,n,m,grid,visited);
//         }
//         else if(grid[i][j]==3){
//             dfs(i,j-1,n,m,grid,visited);
//             dfs(i+1,j,n,m,grid,visited);
//         }
//         else if(grid[i][j]==4){
//             dfs(i,j+1,n,m,grid,visited);
//             dfs(i+1,j,n,m,grid,visited);
//         }
//         else if(grid[i][j]==5){
//             dfs(i,j-1,n,m,grid,visited);
//             dfs(i-1,j,n,m,grid,visited);
//         }
//         else if(grid[i][j]==6){
//             dfs(i,j+1,n,m,grid,visited);
//             dfs(i-1,j,n,m,grid,visited);
//         }


//     }
// }



class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] visited = new boolean [n][m];
        dfs(0,0,n,m,grid,visited);
        return visited[n-1][m-1];
    }

    public static void dfs (int i , int j , int n , int m ,int [][] grid, boolean [][] visited){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j]) return;
        visited[i][j]=true;

        if(grid[i][j]==1){
            // LEFT
            if(j-1>=0 && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6)){
                dfs(i,j-1,n,m,grid,visited);
            }
            // RIGHT
            if(j+1<m && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5)){
                dfs(i,j+1,n,m,grid,visited);
            }
        }
        else if(grid[i][j]==2){
            // UP
            if(i-1>=0 && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4)){
                dfs(i-1,j,n,m,grid,visited);
            }
            // DOWN
            if(i+1<n && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6)){
                dfs(i+1,j,n,m,grid,visited);
            }
        }
        else if(grid[i][j]==3){
            // LEFT
            if(j-1>=0 && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6)){
                dfs(i,j-1,n,m,grid,visited);
            }
            // DOWN
            if(i+1<n && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6)){
                dfs(i+1,j,n,m,grid,visited);
            }
        }
        else if(grid[i][j]==4){
            // RIGHT
            if(j+1<m && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5)){
                dfs(i,j+1,n,m,grid,visited);
            }
            // DOWN
            if(i+1<n && (grid[i+1][j]==2 || grid[i+1][j]==5 || grid[i+1][j]==6)){
                dfs(i+1,j,n,m,grid,visited);
            }
        }
        else if(grid[i][j]==5){
            // LEFT
            if(j-1>=0 && (grid[i][j-1]==1 || grid[i][j-1]==4 || grid[i][j-1]==6)){
                dfs(i,j-1,n,m,grid,visited);
            }
            // UP
            if(i-1>=0 && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4)){
                dfs(i-1,j,n,m,grid,visited);
            }
        }
        else if(grid[i][j]==6){
            // RIGHT
            if(j+1<m && (grid[i][j+1]==1 || grid[i][j+1]==3 || grid[i][j+1]==5)){
                dfs(i,j+1,n,m,grid,visited);
            }
            // UP
            if(i-1>=0 && (grid[i-1][j]==2 || grid[i-1][j]==3 || grid[i-1][j]==4)){
                dfs(i-1,j,n,m,grid,visited);
            }
        }
    }
}