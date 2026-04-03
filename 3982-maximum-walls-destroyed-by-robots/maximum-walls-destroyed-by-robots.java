class Solution {
    private int lowerBound(int[] walls, long target) {
        int low = 0, high = walls.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (walls[mid] < target) 
                low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int upperBound(int[] walls, long target) {
        int low = 0, high = walls.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (walls[mid] <= target) 
                low = mid + 1;
            else high = mid;
        }
        return low;
    }

    private int countWalls(int[] walls, long l, long r) {
        if (l > r) 
            return 0;
        return upperBound(walls, r) - lowerBound(walls, l);
    }

    private static class Robot {
        long pos;
        int dist;
        Robot(long pos, int dist) {
            this.pos = pos;
            this.dist = dist;
        }
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        if (n == 0) 
            return 0;

        Arrays.sort(walls);

        Robot[] rData = new Robot[n];
        for (int i = 0; i < n; i++) {
            rData[i] = new Robot(robots[i], distance[i]);
        }
        Arrays.sort(rData, (a, b) -> Long.compare(a.pos, b.pos));

        int[][] dp = new int[n][2];

        long INF = 2_000_000_000_000_000_000L;
        long pos0 = rData[0].pos;
        int dist0 = rData[0].dist;
        long nextR = (n > 1) ? rData[1].pos : INF;

        dp[0][0] = countWalls(walls, pos0 - dist0, pos0);
        dp[0][1] = countWalls(walls, pos0, Math.min(pos0 + dist0, nextR - 1));

        for (int i = 1; i < n; i++) {
            long curP = rData[i].pos;
            int curD = rData[i].dist;
            long preP = rData[i - 1].pos;
            int preD = rData[i - 1].dist;
            nextR = (i + 1 < n) ? rData[i + 1].pos : INF;

            int rGain = countWalls(walls, curP, Math.min(curP + curD, nextR - 1));
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]) + rGain;

            long lLim = Math.max(curP - curD, preP + 1);
            int lGain = countWalls(walls, lLim, curP);

            int caseLeft = dp[i - 1][0] + lGain;

            long overR = Math.min(preP + preD, curP - 1);
            int overlap = countWalls(walls, lLim, overR);
            int caseRight = dp[i - 1][1] + lGain - overlap;

            dp[i][0] = Math.max(caseLeft, caseRight);
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}