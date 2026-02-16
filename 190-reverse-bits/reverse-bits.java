class Solution {
    public int reverseBits(int n) {
        // String padded = String.format("%32d", n);
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(n));
        int len = 32-sb.length();
        StringBuilder dummy = new StringBuilder();
        for(int i =0;i<len;i++){
            dummy.append("0");
        }
        dummy.append(sb);
        dummy.reverse();
        String ans = dummy.toString();
        return Integer.parseInt(ans,2);
    
    }
}    