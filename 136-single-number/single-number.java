// class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
//         }
//         for(int key:map.keySet()){
//             if(map.get(key)==1){
//                 return key;
//             }
//         }
//         return -1;
        
//     }
// }

class Solution {
    public int singleNumber(int[] nums) {
        int xor=0;
        for(int i=0;i<nums.length;i++){
            xor^=nums[i];
        }
        return xor;
        
    }
}