class Solution {
    public int uniqueXorTriplets(int[] nums) {
        final int MAX = 2048;

        boolean[] present = new boolean[1501];
        for (int x : nums) {
            present[x] = true;
        }

        boolean[][] dp = new boolean[4][MAX];
        dp[0][0] = true;

        for (int take = 1; take <= 3; take++) {
            for (int xor = 0; xor < MAX; xor++) {
                if (!dp[take - 1][xor]) continue;

                for (int val = 1; val <= 1500; val++) {
                    if (present[val]) {
                        dp[take][xor ^ val] = true;
                    }
                }
            }
        }

        int ans = 0;
        for (boolean b : dp[3]) {
            if (b) ans++;
        }

        return ans;
    }
}