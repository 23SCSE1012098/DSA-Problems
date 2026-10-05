// class Solution {
//     public int scoreOfParentheses(String s) {
//         int n = s.length();
//         int count=0;
//         Stack<Character> st = new Stack();
//         for(int i =0;i<n;i++){
//             if(s.charAt(i)=='('){
//                 st.push(s.charAt(i));
//             }
//             else{
//                 if(s.charAt(i)==')' && !st.isEmpty() && st.peek()=='('){
//                     count++;
//                     st.pop();
//                 }
//             }
//         }
//         return count;
        
//     }
// }


class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                st.push(0);
            } else {
                int val = st.pop();

                if (val == 0) {
                    val = 1;
                } else {
                    val = 2 * val;
                }

                if (!st.isEmpty()) {
                    int top = st.pop();
                    st.push(top + val);
                } else {
                    st.push(val);
                }
            }
        }

        return st.peek();
    }
}