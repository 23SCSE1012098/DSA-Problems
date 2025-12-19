class Solution {
    public int compress(char[] chars) {
        int index = 0;   // write pointer
        int i = 0;       // read pointer

        while (i < chars.length) {
            char current = chars[i];
            int count = 0;

            // count consecutive characters
            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            // write character
            chars[index++] = current;

            // write count if > 1
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}
