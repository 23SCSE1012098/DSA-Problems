class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        int ans=0;
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                builder.append( '1');

            }
            else {
                builder.append('0');
            }
        }
        ans = Integer.parseInt(builder.toString(),2);
        return ans;
        
    }
}