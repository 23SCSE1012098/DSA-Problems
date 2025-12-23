class Solution {
    int[][] dp;

    public int longestPalindromeSubseq(String s) {
        String rs = new StringBuilder(s).reverse().toString();
        int n = s.length();
        dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, rs, n, n);
    }

    private int solve(String s, String rs, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (dp[m][n] != -1) return dp[m][n];

        if (s.charAt(m - 1) == rs.charAt(n - 1)) {
            return dp[m][n] = 1 + solve(s, rs, m - 1, n - 1);
        } else {
            return dp[m][n] = Math.max(solve(s, rs, m - 1, n),solve(s, rs, m, n - 1));
        }
    }
}
