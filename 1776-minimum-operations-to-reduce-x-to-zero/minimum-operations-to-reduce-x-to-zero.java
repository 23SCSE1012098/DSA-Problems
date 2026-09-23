class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum =0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            map.put(sum,i);
        }
        if(sum<x) return -1;
        int remainingsum = sum-x;
        int longestSubarray = Integer.MIN_VALUE;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int findsum = sum-remainingsum;
            if(map.containsKey(findsum)){
                int idx = map.get(findsum);
                longestSubarray = Math.max(longestSubarray,i-idx);
            }
        }
        return longestSubarray==Integer.MIN_VALUE ? -1:(n-longestSubarray);

    }
}