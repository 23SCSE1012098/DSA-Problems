class Solution {
    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1;

        // Skip trailing spaces
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }

        int count = 0;

        // Count last word
        while (idx >= 0 && s.charAt(idx) != ' ') {
            count++;
            idx--;
        }

        return count;
    }
}
