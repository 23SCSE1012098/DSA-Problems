class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;

        // Build prefix sum array
        int[][] prefix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1]
                        + prefix[i - 1][j]
                        + prefix[i][j - 1]
                        - prefix[i - 1][j - 1];
            }
        }

        int left = 0, right = Math.min(m, n);
        int answer = 0;

        // Binary search on side length
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (existsSquare(prefix, mid, threshold)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    // Check if any square of size k has sum <= threshold
    private boolean existsSquare(int[][] prefix, int k, int threshold) {
        if (k == 0) return true;

        int m = prefix.length;
        int n = prefix[0].length;

        for (int i = k; i < m; i++) {
            for (int j = k; j < n; j++) {
                int sum = prefix[i][j]
                        - prefix[i - k][j]
                        - prefix[i][j - k]
                        + prefix[i - k][j - k];

                if (sum <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
