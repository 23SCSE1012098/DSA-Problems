class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long minVal = Long.MAX_VALUE;
        long maxVal = Long.MIN_VALUE;

        for (int num : nums) {
            minVal = Math.min(minVal, num);
            maxVal = Math.max(maxVal, num);
        }

        return (maxVal - minVal) * (long) k;
    }
}