
class Solution {

    // Check if Koko can eat all
    private boolean isPossible(int[] piles, int h, int k) {
        long hours = 0;

        for (int bananas : piles) {
            hours += (bananas + k - 1) / k; // ceil division
            if (hours > h) return false;
        }
        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        int ans = high;

        // Binary Search on Answer
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (isPossible(piles, h, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}
