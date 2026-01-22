import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        int operations = 0;

        while (!isNonDecreasing(list)) {
            // find the leftmost adjacent pair with the minimum sum
            int minSum = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            // replace pair at idx and idx+1 with their sum at idx
            list.set(idx, minSum);
            list.remove(idx + 1);
            operations++;
        }

        return operations;
    }

    // check if array is non-decreasing
    private boolean isNonDecreasing(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) return false;
        }
        return true;
    }
}
