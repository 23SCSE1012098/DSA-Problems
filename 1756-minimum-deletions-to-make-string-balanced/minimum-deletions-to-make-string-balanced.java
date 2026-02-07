class Solution {
    public int minimumDeletions(String s) {
        int count=0;
        int n = s.length();
        Stack<Character> stack =new Stack<>();
        for(int i=0;i<n;i++){
            if(!stack.empty() && s.charAt(i)=='a' && stack.peek()=='b'){
                stack.pop();
                count++;
            }
            
            else{
                stack.push(s.charAt(i));
            }
            
        }
        return count;

        
        
    }
}