class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int MOD = 1_000_000_007;
        int NEG = -1_000_000_000;

        int[][] score = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(score[i], NEG);
        }

        score[0][0] = 0;
        ways[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (board.get(i).charAt(j) == 'X') continue;
                if (i == 0 && j == 0) continue;

                int best = NEG;
                long count = 0;

                // From top
                if (i > 0 && ways[i - 1][j] > 0) {
                    if (score[i - 1][j] > best) {
                        best = score[i - 1][j];
                        count = ways[i - 1][j];
                    } else if (score[i - 1][j] == best) {
                        count += ways[i - 1][j];
                    }
                }

                // From left
                if (j > 0 && ways[i][j - 1] > 0) {
                    if (score[i][j - 1] > best) {
                        best = score[i][j - 1];
                        count = ways[i][j - 1];
                    } else if (score[i][j - 1] == best) {
                        count += ways[i][j - 1];
                    }
                }

                // From diagonal
                if (i > 0 && j > 0 && ways[i - 1][j - 1] > 0) {
                    if (score[i - 1][j - 1] > best) {
                        best = score[i - 1][j - 1];
                        count = ways[i - 1][j - 1];
                    } else if (score[i - 1][j - 1] == best) {
                        count += ways[i - 1][j - 1];
                    }
                }

                if (count == 0) continue;

                char ch = board.get(i).charAt(j);
                int val = Character.isDigit(ch) ? ch - '0' : 0;

                score[i][j] = best + val;
                ways[i][j] = (int) (count % MOD);
            }
        }

        if (ways[n - 1][n - 1] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{score[n - 1][n - 1], ways[n - 1][n - 1]};
    }
}