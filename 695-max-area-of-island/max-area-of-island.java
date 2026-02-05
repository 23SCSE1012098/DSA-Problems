// class Solution {
//     public int maxAreaOfIsland(int[][] grid) {
//         if (grid == null || grid.length == 0 || grid[0].length == 0) {
//             return 0;
//         }
//         int ans=0;
        
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == '1') {
//                     int [] area = new int [1];
//                     dfs(grid, i, j, area);
//                     ans=Math.max(ans,area[0]);
//                 }
//             }
//         }

//         return ans;
//     }

//     public void dfs(int[][] grid, int i, int j, int[] area) {

//         if (i < 0 || i >= grid.length ||
//             j < 0 || j >= grid[0].length ||
//             grid[i][j] == '0') {
//             return;
//         }

//         grid[i][j] = '0';
//         area[0]++;

//         dfs(grid, i + 1, j);
//         dfs(grid, i - 1, j);
//         dfs(grid, i, j + 1);
//         dfs(grid, i, j - 1);
    
        
//     }
// }

class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int ans = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int[] area = new int[1];  
                    dfs(grid, i, j, area);
                    ans = Math.max(ans, area[0]);
                }
            }
        }

        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int[] area) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        area[0]++;       

        dfs(grid, i + 1, j, area);
        dfs(grid, i - 1, j, area);
        dfs(grid, i, j + 1, area);
        dfs(grid, i, j - 1, area);
    }
}
