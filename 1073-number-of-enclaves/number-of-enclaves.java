// class Solution {
//     public int numEnclaves(int[][] grid) {
//         int m=grid.length;
//         int n = grid[0].length;
//         int[][] visited = new int [m][n];
//         int count=0;
//         for(int i =0;i<m;i++){
//            if(grid[i][0]==1){
//             dfs(grid,visited,i,0);
//             dfs(grid,visited,i,n-1);
//            } 
//         }
//         for(int i=0; i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(grid[i][j]==1){
//                     count++;
//                 }
//             }
//         }
//         return count;

        
//     }
//     public void dfs(int[][] grid,int[][] visited,int i, int j){
//         int m = grid.length;
//         int n = grid[0].length;
//         if(i<0 ||i>=m || j<0 || j>=n || grid.length==0 || grid[i][j]==0) {
//             return;

//         }
//         visited[i][j]=0;
//         dfs(grid,visited,i+1,j);
//         dfs(grid,visited,i-1,j);
//         dfs(grid,visited,i,j+1);
//         dfs(grid,visited,i,j-1);
//     }
// }

class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // DFS from all boundary cells
        for (int i = 0; i < m; i++) {
            dfs(grid, visited, i, 0);
            dfs(grid, visited, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(grid, visited, 0, j);
            dfs(grid, visited, m - 1, j);
        }

        // Count land cells NOT visited (enclaves)
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;

        if (i < 0 || i >= m || j < 0 || j >= n) return;
        if (grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
