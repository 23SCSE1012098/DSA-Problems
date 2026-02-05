// class Solution {
//     public int islandPerimeter(int[][] grid) {

//         if (grid == null || grid.length == 0 || grid[0].length == 0) {
//             return 0;
//         }

//         int perimeter = 0;
//         int rows = grid.length;
//         int cols = grid[0].length;

//         for (int i = 0; i < rows; i++) {
//             for (int j = 0; j < cols; j++) {

//                 if (grid[i][j] == 1) {
//                     perimeter += 4;

//                     // shared edge with top
//                     if (i > 0 && grid[i - 1][j] == 1) {
//                         perimeter -= 2;
//                     }

//                     // shared edge with left
//                     if (j > 0 && grid[i][j - 1] == 1) {
//                         perimeter -= 2;
//                     }
//                 }
//             }
//         }

//         return perimeter;
//     }
// }

class Solution {

    int perimeter = 0;

    public int islandPerimeter(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        // find first land cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j);
                    return perimeter;
                }
            }
        }

        return 0;
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j) {

        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            perimeter++;   // boundary or water adds to perimeter
            return;
        }

        if (visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }
}
