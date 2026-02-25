// class Solution {
//     public int[] sortByBits(int[] arr) {
//         Integer temp[] = new Integer[arr.length];
        
//         for(int i = 0; i < arr.length; i++){
//             temp[i] = arr[i];
//         }

//         Arrays.sort(temp, (a, b) -> {
//             int bitofa = Integer.bitCount(a);
//             int bitofb = Integer.bitCount(b);

//             if(bitofa == bitofb) return a - b;
//             return bitofa - bitofb;
//         });

//         for(int i = 0; i < arr.length; i++){
//             arr[i] = temp[i];
//         }

//         return arr;
//     }
// }

class Solution {
    public int[] sortByBits(int[] arr) {
        int temp[] = new int [arr.length];
        Arrays.sort(arr);
        
        int index=0;
        for(int i=0;i<32;i++){
            for(int j=0;j<arr.length;j++){
                if(i==Integer.bitCount(arr[j])){
                    temp[index++]=arr[j];
                }
            }
        }

        return temp;
    }
}