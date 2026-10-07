class Solution {
    int max = 0;
    boolean isValid(String s){
        int count = 0;

        for(char ch : s.toCharArray()){
            if(ch == '('){
                count++;
            }
            else if(ch == ')'){
                count--;
            }
            if(count < 0) return false;
        }

        return count == 0;
    }
    void helper(int i , String temp,HashSet<String> ar,String s){

        if(i == s.length()){
            if(isValid(temp)){
                if(temp.length() > max){
                    ar.clear();
                    max = temp.length();
                    ar.add(temp);
                }
                if(temp.length() == max){
                    ar.add(temp);
                }

            }
            return;
        }

        char ch = s.charAt(i);

        helper(i+1,temp+ch,ar,s);

        if(ch == '('|| ch == ')'){
            helper(i+1,temp,ar, s);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> ar = new HashSet<>();

        helper(0,"",ar,s);

        return new ArrayList<>(ar);
    }
}