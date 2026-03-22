class Solution {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        
        // Step 1: Store sums of nums1 and nums2
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int a : nums1) {
            for (int b : nums2) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        
        // Step 2: Check sums of nums3 and nums4
        int count = 0;
        
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += map.getOrDefault(target, 0);
            }
        }
        
        return count;
    }
}