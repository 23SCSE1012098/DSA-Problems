// class Solution {
//     public List<Integer> findMissingElements(int[] nums) {
//         List<Integer> ans = new ArrayList<>();
//         Arrays.sort(nums);
//         int f = nums[0];
//         int l = nums[nums.length-1];
//         int totalsum = 0;
//         for(int i=f;i<=l;i++){
//             totalsum +=i; 

//         }
//         int sum=0;
//         for(int i =0;i<nums.length;i++){
//             sum+=nums[i];

//         }
//         if(totalsum-sum==0){
//             return ans;
//         }
//         ans.add(totalsum-sum);
//         return ans;
        
//     }
// }


class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            int curr = nums[i];
            int next = nums[i + 1];

            for (int j = curr + 1; j < next; j++) {
                ans.add(j);
            }
        }

        return ans;
    }
}