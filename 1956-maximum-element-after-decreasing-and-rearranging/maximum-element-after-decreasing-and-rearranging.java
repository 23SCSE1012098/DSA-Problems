import java.util.Arrays;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);

        // Step 2: Make the first element 1
        arr[0] = 1;

        // Step 3: Adjust the remaining elements
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i], arr[i - 1] + 1);
        }

        // Step 4: Return the maximum element
        return arr[arr.length - 1];
    }
}