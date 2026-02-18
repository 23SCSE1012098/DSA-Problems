class Solution {
    public boolean hasAlternatingBits(int n) {
        if (n == 0) {
            return true;
        }
        String s = Integer.toBinaryString(n);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                return false;
            }
        }
        return true;
        
    }
}