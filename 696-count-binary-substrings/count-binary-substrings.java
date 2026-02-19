class Solution {
    public int countBinarySubstrings(String s) {
        int count=0;
        int currcount=1;
        int prevcount=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
               currcount++;
            }
            else {
                count += Math.min(prevcount,currcount);
                prevcount=currcount;
                currcount=1;
            }
            
        }
        
        return count+ Math.min(currcount, prevcount);

        
    }
}