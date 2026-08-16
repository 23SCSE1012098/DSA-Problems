// class Solution {
//     public boolean stoneGameIX(int[] stones) {
//         int totalsum =0;
//         if((stones.length%2)!=0){
//             return false;
//         }
//         if(stones.length==2 && stones[0]==stones[1]){
//             return false;
//         }
//         for(int x:stones){
//             totalsum+=x;
            
//         }
//         if((totalsum%3)==0){
//             return true;
//         }

//         return false;
        
//     }
// }

class Solution {
    public boolean stoneGameIX(int[] stones) {

        int[] count = new int[3];

        for (int x : stones) {
            count[x % 3]++;
        }

        // If number of remainder-0 stones is even
        if (count[0] % 2 == 0) {
            return count[1] > 0 && count[2] > 0;
        }

        // If number of remainder-0 stones is odd
        return Math.abs(count[1] - count[2]) > 2;
    }
}