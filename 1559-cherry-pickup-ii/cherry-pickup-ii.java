class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][m];

        // Initialize DP with -1
        for (int i = 0; i < n; i++) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return solve(0, 0, m - 1, grid, dp);
    }

    public int solve(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int n = grid.length;
        int m = grid[0].length;

        // Boundary check
        if (j1 < 0 || j2 < 0 || j1 >= m || j2 >= m) {
            return -1000000; // invalid path
        }

        // Base case (last row)
        if (i == n - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        // DP check
        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = 0;

        // Try all 9 moves
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int value;
                if (j1 == j2)
                    value = grid[i][j1];
                else
                    value = grid[i][j1] + grid[i][j2];

                value += solve(i + 1, j1 + dj1, j2 + dj2, grid, dp);

                maxi = Math.max(maxi, value);
            }
        }

        return dp[i][j1][j2] = maxi;
    }
}