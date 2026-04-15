class Solution {
    public String longestPalindrome(String s) {
        int maxlen =0;
        int startidx =-1;
        for(int i=0;i<s.length();i++){
            for(int j =i;j<s.length();j++){
                if(solve(s,i,j)){
                    if(j-i+1 > maxlen){
                        maxlen=j-i+1;
                        startidx = i;
                    }
                }

            }
        }
        return s.substring(startidx,startidx+maxlen);
        
    }
    public static boolean solve(String s, int i , int j){

        if(i>=j){
            return true;
        }
        if(s.charAt(i)==s.charAt(j)){
            return solve(s,i+1,j-1);
        }
        
        return false;
        
    }
    
}