class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            int pos=ch-'a'+1;
            int cval = 27-pos;
            sum+=(cval*(i+1));

        }
        return sum;
    }
}