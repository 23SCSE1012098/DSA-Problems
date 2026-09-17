class Solution {
    public int minSumOfLengths(int[] arr, int target) {

        int n = arr.length;

        // best[i] = minimum length of a valid subarray
        // ending before index i
        int[] best = new int[n];

        int INF = 1000000000;

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }

        int left = 0;
        int sum = 0;
        int ans = INF;
        int minLen = INF;

        for (int right = 0; right < n; right++) {

            sum += arr[right];

            // Shrink window if sum becomes greater than target
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            // We found a subarray [left ... right]
            if (sum == target) {

                int len = right - left + 1;

                // Check if there is a previous non-overlapping subarray
                if (left > 0 && best[left - 1] != INF) {
                    ans = Math.min(ans, len + best[left - 1]);
                }

                // Keep the shortest valid subarray seen so far
                minLen = Math.min(minLen, len);
            }

            // Store the best subarray ending at or before right
            if (right == 0) {
                best[right] = minLen;
            } else {
                best[right] = Math.min(best[right - 1], minLen);
            }
        }

        return ans == INF ? -1 : ans;
    }
}