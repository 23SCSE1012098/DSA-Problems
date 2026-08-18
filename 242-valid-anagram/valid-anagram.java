class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] s2= t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        s= new String (s1);
        t= new String (s2);
        if(s.equals(t)) return true;
        return false;
        
    }
}