class Solution {
    public int minimumDistance(String word) {
        int n = word.length();
        
        // dp[j] = max saving when second finger is at letter j
        int[] dp = new int[26];
        
        int total = 0;
        
        for (int i = 1; i < n; i++) {
            int cur = word.charAt(i) - 'A';
            int prev = word.charAt(i - 1) - 'A';
            
            int d = dist(prev, cur);
            total += d;
            
            int[] newDp = dp.clone();
            
            for (int j = 0; j < 26; j++) {
                int saving = dp[j] + d - dist(j, cur);
                newDp[prev] = Math.max(newDp[prev], saving);
            }
            
            dp = newDp;
        }
        
        int maxSaving = 0;
        for (int val : dp) {
            maxSaving = Math.max(maxSaving, val);
        }
        
        return total - maxSaving;
    }
    
    private int dist(int a, int b) {
        int x1 = a / 6, y1 = a % 6;
        int x2 = b / 6, y2 = b % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}