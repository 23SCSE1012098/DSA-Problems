//RECURSION APPROACH
// class Solution {
//     int total;
//     int n;
//     public int minimumDifference(int[] nums) {
//         n= nums.length/2;
//         total =0;
//         for(int num:nums){
//             total+=num;
//         }
//         return solve(nums.length-1,0,0,nums);
        
//     }
//     public int solve(int i,int count, int s1,int []nums){
//         if(i<0){
//             return Integer.MAX_VALUE;
//         }
//         if(count==n){
//             return Math.abs(2*s1 - total);
//         }
//         int select = solve(i-1, count+1,s1+nums[i],nums);
//         int skip = solve (i-1,count,s1,nums);
//         return Math.min(select,skip);
//     }
// }


// class Solution {
//     public int minimumDifference(int[] nums) {
//         int N = nums.length;
//         int n = N / 2;
//         int total = 0;

//         for (int x : nums) total += x;

//         // dp[k] = all possible sums using k elements
//         HashSet<Integer>[] dp = new HashSet[n + 1];
//         for (int i = 0; i <= n; i++) {
//             dp[i] = new HashSet<>();
//         }

//         dp[0].add(0);

//         for (int num : nums) {
//             // traverse backwards to avoid reuse
//             for (int k = n - 1; k >= 0; k--) {
//                 for (int s : dp[k]) {
//                     dp[k + 1].add(s + num);
//                 }
//             }
//         }

//         int ans = Integer.MAX_VALUE;

//         for (int s1 : dp[n]) {
//             ans = Math.min(ans, Math.abs(total - 2 * s1));
//         }

//         return ans;
//     }
// }


class Solution {
    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N / 2;
        int total = 0;
        for (int x : nums) total += x;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, N);

        // dpL[k] = sums using k elements from left half
        // dpR[k] = sums using k elements from right half
        List<Integer>[] dpL = new List[n + 1];
        List<Integer>[] dpR = new List[n + 1];

        for (int i = 0; i <= n; i++) {
            dpL[i] = new ArrayList<>();
            dpR[i] = new ArrayList<>();
        }

        gen(left, 0, 0, 0, dpL);
        gen(right, 0, 0, 0, dpR);

        for (int i = 0; i <= n; i++) {
            Collections.sort(dpR[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> A = dpL[k];
            List<Integer> B = dpR[n - k];

            for (int s : A) {
                int target = total / 2 - s;
                int idx = Collections.binarySearch(B, target);

                if (idx >= 0) {
                    ans = Math.min(ans, Math.abs(total - 2 * (s + B.get(idx))));
                } else {
                    idx = -idx - 1;
                    if (idx < B.size()) {
                        ans = Math.min(ans, Math.abs(total - 2 * (s + B.get(idx))));
                    }
                    if (idx > 0) {
                        ans = Math.min(ans, Math.abs(total - 2 * (s + B.get(idx - 1))));
                    }
                }
            }
        }

        return ans;
    }

    private void gen(int[] arr, int idx, int count, int sum, List<Integer>[] dp) {
        if (idx == arr.length) {
            dp[count].add(sum);
            return;
        }
        gen(arr, idx + 1, count, sum, dp);
        gen(arr, idx + 1, count + 1, sum + arr[idx], dp);
    }
}
