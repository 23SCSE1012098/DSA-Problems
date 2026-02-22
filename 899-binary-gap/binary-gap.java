class Solution {
    public int binaryGap(int n) {
        int ans = 0;
        String s = Integer.toBinaryString(n);

        int prev = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (prev != -1) {
                    ans = Math.max(ans, i - prev);
                }
                prev = i;
            }
        }

        return ans;
    }
}