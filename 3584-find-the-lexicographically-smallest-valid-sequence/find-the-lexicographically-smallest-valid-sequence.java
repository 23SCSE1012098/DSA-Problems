class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];

        // last[j] = position in word1 where word2[j]
        // can be matched from the right side
        java.util.Arrays.fill(last, -1);

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        int[] ans = new int[m];

        boolean changed = false;
        j = 0;

        // Greedily select the smallest possible index
        for (i = 0; i < n; i++) {

            if (j == m) {
                break;
            }

            // Normal matching
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j] = i;
                j++;
            }

            // Use this position as the ONE mismatch
            else if (!changed &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                changed = true;
                j++;
            }
        }

        // Could not construct word2
        if (j < m) {
            return new int[0];
        }

        return ans;
    }
}