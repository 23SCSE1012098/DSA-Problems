class Solution {
    public int numberOfSpecialChars(String word) {

        int count = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int lastLower = -1;
            int firstUpper = -1;

            // find positions
            for (int i = 0; i < word.length(); i++) {

                if (word.charAt(i) == ch) {
                    lastLower = i;
                }

                if (word.charAt(i) == (char)(ch - 'a' + 'A')) {

                    if (firstUpper == -1) {
                        firstUpper = i;
                    }
                }
            }

            // valid special character
            if (lastLower != -1 &&
                firstUpper != -1 &&
                lastLower < firstUpper) {

                count++;
            }
        }

        return count;
    }
}