// class Solution {
//     public int numSteps(String s) {
//         int step =0;
//         if(s.length()==1){
//             return 0;
//         }
//         int num = Integer.parseInt(s, 2); 
//         while(num!=1){
//             if(num%2==0){
//                 num=num/2;
//                 step++;
//             }
//             else{
//                 num+=1;
//                 step++;
//             }
//         }
//         return step;

//     }
// }


class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int step =0;
        int carry=0;
        for(int i=n-1;i>=1;i--){
            if(((s.charAt(i)-'0')+carry)%2==1){
                step+=2;
                carry=1;
            }
            else{
                step+=1;

            }
        }
        return step+carry;

    }
}