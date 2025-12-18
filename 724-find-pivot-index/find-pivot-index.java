class Solution {
    public int pivotIndex(int[] nums) {

        int rsum = 0;

        // Calculate total sum (right sum initially)
        for (int ele : nums) {
            rsum += ele;
        }

        int lsum = 0;

        // Traverse array to find pivot index
        for (int i = 0; i < nums.length; i++) {

            rsum -= nums[i];   // remove current element from right sum

            if (lsum == rsum) {
                return i;      // pivot index found
            }

            lsum += nums[i];   // add current element to left sum
        }

        return -1; // no pivot index found
    }
}