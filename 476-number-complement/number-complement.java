class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
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