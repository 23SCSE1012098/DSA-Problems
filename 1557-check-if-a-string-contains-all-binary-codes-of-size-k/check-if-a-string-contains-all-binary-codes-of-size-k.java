class Solution {
    public boolean hasAllCodes(String s, int k) {
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=s.length()-k;i++){
            String sb = s.substring(i,i+k);
            set.add(sb);
        }
        int total = (int)Math.pow(2,k);
        return set.size()==total;
        
    }
}