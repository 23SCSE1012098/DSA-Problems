// class Solution {
//     Set<String> set = new HashSet<>();
//     int dp [];

//     public int distinctSubseqII(String s) {
//         dp = new int[s.length()];
//         solve(0, s, "");
//         return set.size();
//     }

//     void solve(int i, String s, String curr) {

//         if (i == s.length()) {
//             if (curr.length() > 0) {
//                 set.add(curr);
//             }
//             return;
//         }

//         // Take
//         solve(i + 1, s, curr + s.charAt(i));

//         // Skip
//         solve(i + 1, s, curr);
//     }
// }


// class Solution {

//     public int distinctSubseqII(String s) {
//         int MOD=10^9 + 7;
//         int n = s.length();
//         int dp [] = new int [n+1];
//         dp[0]=1;
//         for(int i=1;i<=n;i++){
//             dp[i]=(2*dp[i-1])%MOD;
//         }
//         return dp[n]-1;
        
//     }

    
// }


class Solution {
    public int distinctSubseqII(String s) {

        int n = s.length();
        long[] dp = new long[n + 1];

        dp[0] = 1; // empty subsequence

        int[] last = new int[26];
        Arrays.fill(last, -1);

        long MOD = 1000000007;

        for (int i = 1; i <= n; i++) {

            char ch = s.charAt(i - 1);

            dp[i] = (2 * dp[i - 1]) % MOD;

            int prev = last[ch - 'a'];

            if (prev != -1) {
                dp[i] = (dp[i] - dp[prev - 1] + MOD) % MOD;
            }

            last[ch - 'a'] = i;
        }

        // remove empty subsequence
        return (int)((dp[n] - 1 + MOD) % MOD);
    }
}