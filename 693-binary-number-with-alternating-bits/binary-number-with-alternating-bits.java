class Solution {
    public boolean hasAlternatingBits(int n) {
        if(n==0){
            return true;
        }
        String s1= Integer.toBinaryString(n);
        int l = s1.length()-1;
        while(l!=0){
            if(s1.charAt(l)==s1.charAt(l-1)){
                return false;
            }
            l--;
        }
        return true;
        
    }
}