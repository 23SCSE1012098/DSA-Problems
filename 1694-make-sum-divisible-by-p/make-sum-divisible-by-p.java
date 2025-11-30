class Solution {
    public int minSubarray(int[] nums, int p) {
        int totalSum = 0;
        for (int num:nums){
            totalSum=(totalSum+num)%p;
        }
        if(totalSum==0) return 0;
        int remainder=totalSum;
        HashMap<Integer,Integer> prefixMap =new HashMap<>();
        prefixMap.put(0,-1);
        int currentSum=0;
        int minLength=nums.length;
        for(int i=0;i<nums.length;i++){
            currentSum=(currentSum+nums[i])%p;
            int target = (currentSum-remainder+p)%p;
            if(prefixMap.containsKey(target)){
                minLength=Math.min(minLength,i-prefixMap.get(target));
            }
            prefixMap.put(currentSum,i);
        
        }
        return minLength==nums.length?-1:minLength;
        
    }
}