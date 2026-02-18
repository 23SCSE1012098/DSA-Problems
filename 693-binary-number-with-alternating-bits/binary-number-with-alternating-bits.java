class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==0){
            return true;
        }
        String s1= Integer.toBinaryString(n);
        for(int i=1;i<s1.length();i++){
            if(s1.charAt(i)==s1.charAt(i-1)){
                return false;
            }
            
        }
        return true;
        
    }
}