// class Solution {
//     public int minimumDeletions(String s) {
//         int count=0;
//         int n = s.length();
//         Stack<Character> stack =new Stack<>();
//         for(int i=0;i<n;i++){
//             if(!stack.empty() && s.charAt(i)=='a' && stack.peek()=='b'){
//                 stack.pop();
//                 count++;
//             }
            
//             else{
//                 stack.push(s.charAt(i));
//             }
            
//         }
//         return count;

        
        
//     }
// }

class Solution {
    public int minimumDeletions(String s) {
        int count=0;
        int bcount=0;
        int n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                count=Math.min(bcount,count+1);
            }
            else{
                bcount++;
            }
        }
        return count;
 
    }
}