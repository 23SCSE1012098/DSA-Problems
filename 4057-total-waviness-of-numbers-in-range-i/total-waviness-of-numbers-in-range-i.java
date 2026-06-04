// class Solution {
//     public int totalWaviness(int num1, int num2) {
//         int ans =0;
        
//         for(int n = num1; n<=num2;n++){
//             ArrayList<Integer> list = new ArrayList<>();
//             int a = n;
//             while(a>0){
//                 int digit=(a%10);
//                 list.add(digit);
//                 a=a/10;
//             }
//             Collections.reverse(list);
//             int i=1;
//             while(i<n-1){
//                 if(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)){
//                     ans++;
//                 }
//                 else if(list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1) ){
//                     ans++;
//                 }  
//             }


//         }
//         return ans;
        
//     }
// }

class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;

        for (int n = num1; n <= num2; n++) {
            ArrayList<Integer> list = new ArrayList<>();

            int a = n;
            while (a > 0) {
                list.add(a % 10);
                a /= 10;
            }

            Collections.reverse(list);

            for (int i = 1; i < list.size() - 1; i++) {
                if ((list.get(i) < list.get(i - 1) && list.get(i) < list.get(i + 1)) ||
                    (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1))) {
                    ans++;
                }
            }
        }

        return ans;
    }
}