class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        HashSet<Character> set = new HashSet<>();
        for(char ch: word.toCharArray()){
            set.add(ch);
        }
        int count =0;
        for(char c ='a'; c<='z';c++){
            if(set.contains(c) && set.contains((char)(c-'a'+'A'))){
                count++;
            }
        }
        return count;
        
    }
}