
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Special case for 1
        if (freq.containsKey(1L)) {
            int count = freq.get(1L);
            ans = Math.max(ans, (count % 2 == 1) ? count : count - 1);
        }

        for (long start : freq.keySet()) {
            if (start == 1L) continue;

            long cur = start;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;

                // Prevent overflow
                if (cur > 1_000_000_000L / cur) {
                    break;
                }

                cur *= cur;
            }

            if (freq.getOrDefault(cur, 0) == 1) {
                ans = Math.max(ans, len + 1);
            } else {
                ans = Math.max(ans, Math.max(1, len - 1));
            }
        }

        return ans;
    }
}