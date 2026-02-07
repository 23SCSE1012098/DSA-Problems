class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> used = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (!map.containsKey(c)) {
                if (used.contains(words[i])) return false;
                map.put(c, words[i]);
                used.add(words[i]);
            } else {
                if (!map.get(c).equals(words[i])) return false;
            }
        }
        return true;
    }
}
