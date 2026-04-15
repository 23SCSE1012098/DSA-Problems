class Solution {
    public boolean isBalanced(String num) {
        int sum1 =0;
        int sum2=0;
        for(int i=0;i<num.length();i+=2){
            sum1+=num.charAt(i)-'0';

        }
        for(int i=1;i<num.length();i+=2){
            sum2+=num.charAt(i)-'0';
        }
        if(sum1==sum2){
            return true;
        }
        return false;
    }
}