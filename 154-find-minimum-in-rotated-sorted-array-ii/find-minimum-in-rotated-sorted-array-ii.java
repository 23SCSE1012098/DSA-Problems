class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // Minimum is in right half
            if (nums[mid] > nums[end]) {
                start = mid + 1;
            }

            // Minimum can be mid or in left half
            else if (nums[mid] < nums[end]) {
                end = mid;
            }

            // nums[mid] == nums[end]
            // Cannot decide the side, reduce search space
            else {
                end--;
            }
        }

        return nums[start];
    }
}